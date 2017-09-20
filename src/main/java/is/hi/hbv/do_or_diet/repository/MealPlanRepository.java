package is.hi.hbv.do_or_diet.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.springframework.stereotype.Repository;

import is.hi.hbv.do_or_diet.model.MealPlan;
import is.hi.hbv.do_or_diet.model.MealPlanItem;

@Repository
public class MealPlanRepository {
	private static long id;
	private static ArrayList<MealPlan> mealPlans;

	static
	{
		id = 0;
	}
	
	public ArrayList<MealPlan> getMealPlans() 
	{
		return mealPlans;
	}

	public void addMealPlan(MealPlan m) 
	{
		m.setId(id++);
		mealPlans.add(m);
	}
	
	public static void resetMealPlans()
	{
		MealPlan m = new MealPlan(
				id++,
				"First Meal Plan ever.",
				new ArrayList<MealPlanItem>(), 
				new ArrayList<Date>()
		);
		
		mealPlans = new ArrayList<MealPlan>(Arrays.asList(m));
	}
	
	public static long getId()
	{
		return id;
	}
	
}
