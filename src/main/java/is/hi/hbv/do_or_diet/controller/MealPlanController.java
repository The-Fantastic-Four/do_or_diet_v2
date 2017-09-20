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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import is.hi.hbv.do_or_diet.model.MealPlan;
import is.hi.hbv.do_or_diet.model.MealPlanItem;
import is.hi.hbv.do_or_diet.model.MealType;
import is.hi.hbv.do_or_diet.repository.MealPlanRepository;
import is.hi.hbv.do_or_diet.repository.RecipeRepository;

@Controller
@RequestMapping("/mealplan")
public class MealPlanController {
	@Autowired
	MealPlanRepository mPlanRep;
	@Autowired
	RecipeRepository recipeRep;
	
	@RequestMapping("")
	public String indexPage(Model model)
	{
		addMealPlanListToModel(model);
		return "mealplan/index";
	}
	
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
	
	@RequestMapping("/edit")
	public String editPage(@RequestParam(value = "mId", required = true) int mId, ModelMap model)
	{
		model.addAttribute("mealPlan", mPlanRep.getMealPlans().get(mId));
		model.addAttribute("recipeList", recipeRep.getRecipes());
		return "mealplan/edit/index";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editDateMeal(@RequestParam(value = "recipeId", required = true) int recipeId, Date date, int mId, ModelMap model) 
	{
		MealPlanItem meal = new MealPlanItem(recipeRep.getRecipes().get(recipeId),date,MealType.DINNER);
		mPlanRep.getMealPlans().get(mId).getItems().add(meal);
		return "mealplan/edit/index";
	}
	
	private void addMealPlanListToModel(Model model) 
	{
		ArrayList<MealPlan> mealPlanList = mPlanRep.getMealPlans();
		model.addAttribute("mealPlanList", mealPlanList);
	}
	
	private Date convertToDate(String d) throws ParseException 
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		return df.parse(d);
	}
	
	private ArrayList<Date> generateDatesBetween(Date from, Date to){
		Calendar cal = Calendar.getInstance();
		ArrayList<Date> d = new ArrayList<Date>();
		cal.setTime(from);
		while (cal.getTime().before(to)) {
		    d.add(cal.getTime());
		    System.out.println(cal.getTime());
		    cal.add(Calendar.DATE, 1);
		}
		d.add(cal.getTime());
		return d;
	}
}
