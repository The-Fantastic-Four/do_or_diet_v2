/**
 * MealPlanController enables the user to interact with meal plans
 * @author Eiður Örn Gunnarsson eog26@hi.is
 * @author Viktor Alex Brynjarsson vab18@hi.is
 */

package is.hi.hbv.do_or_diet.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import is.hi.hbv.do_or_diet.model.MealPlan;
import is.hi.hbv.do_or_diet.model.MealPlanItem;
import is.hi.hbv.do_or_diet.model.MealType;
import is.hi.hbv.do_or_diet.repository.MealPlanRepository;
import is.hi.hbv.do_or_diet.repository.RecipeRepository;

@Controller
@RequestMapping("/mealplan")
public class MealPlanController {

	// Instance of the meal plan repository, used to get and create meal plans
	@Autowired
	MealPlanRepository mPlanRep;
	
	// Instance of the recipe repository, used to get and create recipes
	@Autowired
	RecipeRepository recipeRep;
	
	/**
	 * Index page for the meal plans, shows a list of meal plans
	 * @param model the model that contains all the necessary information
	 * @return
	 */
	@RequestMapping("")
	public String indexPage(Model model)
	{
		addMealPlanListToModel(model);
		return "mealplan/index";
	}
	
	/**
	 *  Creates a new meal plan, redirects to the index page upon creation
	 * @param mName the meal plan name
	 * @param fromDate is the date which the meal plan begins on
	 * @param toDate is the date which the meal plan ends on
	 * @param model the model that contains all the necessary information
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String newMealPlan(@RequestParam(value = "mName", required = true) String mName, String fromDate, String toDate, ModelMap model)
	{	
		
		ArrayList<Date> dates = new ArrayList<Date>();
		try {
			dates = generateDatesBetween(convertToDate(fromDate),convertToDate(toDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		MealPlan m = new MealPlan(
				0,
				mName,
				new ArrayList<MealPlanItem>(), 
				dates
		);
		mPlanRep.addMealPlan(m);
		ArrayList<MealPlan> mealPlanList = mPlanRep.getMealPlans();
		model.addAttribute("mealPlanList", mealPlanList);
		
		return "mealplan/index"; 
	}
	
	/**
	 *  Shows a specific meal plan, allows the user to edit it
	 * @param mealPlanId unique identifier for the meal plan that is being viewed
	 * @param model the model that contains all the necessary information
	 * @return
	 */
	@RequestMapping("/{mealPlanId}")
	public String showMealPlan(@PathVariable(value="mealPlanId") int mealPlanId, ModelMap model)
	{
		model.addAttribute("mealPlan", mPlanRep.getMealPlans().get(mealPlanId));
		model.addAttribute("recipeList", recipeRep.getRecipes());
		return "mealplan/show";
	}
	
	/**
	 * Updates a specific meal plan with new information
	 * @param mealPlanId unique identifier for the meal plan to be edited
	 * @param recipeId unique identifier for the recipe to be added to the meal plan
	 * @param dateForRecipe the date for which the meal is planned to be had
	 * @param model the model that contains all the necessary information
	 * @return
	 */
	@RequestMapping(value = "/{mealPlanId}/edit", method = RequestMethod.POST)
	public ModelAndView editDateMeal(@PathVariable(value="mealPlanId") int mealPlanId, @RequestParam(value = "recipeId", required = true) int recipeId, Date dateForRecipe, ModelMap model) 
	{
		long existingMealId = 0;
		boolean mealExists = false;
		MealPlanItem meal = new MealPlanItem(recipeRep.getRecipes().get(recipeId),dateForRecipe,MealType.DINNER);
		ArrayList<MealPlanItem> mealPlanItemList = mPlanRep.getMealPlans().get(mealPlanId).getItems();
		for(MealPlanItem mealItem : mealPlanItemList) {
			if(mealItem.getDate().equals(dateForRecipe)) {
				existingMealId = mealItem.getId();
				mealExists = true;
			}
		}
		
		if(!mealExists) mealPlanItemList.add(meal);
		else {
			/* 
			 * THIS IS A CLAUSE THAT HANDLES CONFLICTNG DATES. LATER RELEASE THAT THIS USE CASE IS 
			 * ACTUALLY APART OF (UDPATE MEALPLANITEMS).
			 */
		}
		return new ModelAndView("redirect:/mealplan/" + mealPlanId);
	}
	
	/**
	 * Add a list of meal plans to the model which can be displayed on the page
	 * @param model the model which the list of meal plans is to be added to.
	 */
	private void addMealPlanListToModel(Model model) 
	{
		ArrayList<MealPlan> mealPlanList = mPlanRep.getMealPlans();
		model.addAttribute("mealPlanList", mealPlanList);
	}
	
	/**
	 * Converts a date from a string to Date
	 * @param d is the String that is to be converted to a Date object.
	 * @return d on date format
	 * @throws ParseException
	 */
	private Date convertToDate(String d) throws ParseException 
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		return df.parse(d);
	}
	
	/**
	 * Creates a list of the days between two days, from and to dates are included
	 * @param from is the date that you start counting from
	 * @param to is final date of the date count
	 * @return list that contains all the dates between and including the from and to dates
	 */
	private ArrayList<Date> generateDatesBetween(Date from, Date to){
		Calendar cal = Calendar.getInstance();
		ArrayList<Date> d = new ArrayList<Date>();
		cal.setTime(from);
		while (cal.getTime().before(to)) {
		    d.add(cal.getTime());
		    cal.add(Calendar.DATE, 1);
		}
		d.add(cal.getTime());
		return d;
	}
}
