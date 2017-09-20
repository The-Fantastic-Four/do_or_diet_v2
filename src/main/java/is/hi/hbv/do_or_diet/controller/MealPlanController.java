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
	
	// Index page for the meal plans, shows a list of meal plans
	@RequestMapping("")
	public String indexPage(Model model)
	{
		addMealPlanListToModel(model);
		return "mealplan/index";
	}
	
	// Creates a new meal plan, redirects to the index page upon creation
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
	
	// Shows a specific meal plan, allows the user to edit it
	@RequestMapping("/{mealPlanId}")
	public String showMealPlan(@PathVariable(value="mealPlanId") int mealPlanId, ModelMap model)
	{
		model.addAttribute("mealPlan", mPlanRep.getMealPlans().get(mealPlanId));
		model.addAttribute("recipeList", recipeRep.getRecipes());
		return "mealplan/show";
	}
	
	// Updates a specific meal plan with new information
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
			 * THIS REQUIRES FIXING FOR A LATER RELEASE THAT THIS USE CASE IS ACTUALLY
			 * APART OF.
			 */
			/*MealPlanItem oldMeal = mealPlanItemList.get((int)existingMealId);
			oldMeal.setRecipe(meal.getRecipe());
			oldMeal.setMealType(meal.getMealType());*/
		}
		return new ModelAndView("redirect:/mealplan/" + mealPlanId);
	}
	
	// Add a list of meal plans to the model which can be displayed on the page
	private void addMealPlanListToModel(Model model) 
	{
		ArrayList<MealPlan> mealPlanList = mPlanRep.getMealPlans();
		model.addAttribute("mealPlanList", mealPlanList);
	}
	
	// Converts a date from a string to Date
	private Date convertToDate(String d) throws ParseException 
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		return df.parse(d);
	}
	
	// Creates a list of the days between two days, from and to dates are included
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
