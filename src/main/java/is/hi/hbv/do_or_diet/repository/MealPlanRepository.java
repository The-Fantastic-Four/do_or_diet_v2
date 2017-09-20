/**
 * MealPlanRepository keeps a list of meal plans
 * @author Eiður Örn Gunnarsson eog26@hi.is
 */
package is.hi.hbv.do_or_diet.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.springframework.stereotype.Repository;

import is.hi.hbv.do_or_diet.model.MealPlan;
import is.hi.hbv.do_or_diet.model.MealPlanItem;

@Repository
public class MealPlanRepository {
	
	/**
	 * The current maximum id for meal plans
	 */
	private static long id;
	
	/**
	 * List of meal plans
	 */
	private static ArrayList<MealPlan> mealPlans;

	static
	{
		id = 0;
	}
	
	public ArrayList<MealPlan> getMealPlans() 
	{
		return mealPlans;
	}

	/**
	 * Add a meal plan to the repository
	 * @param m the meal plan to be added
	 */
	public void addMealPlan(MealPlan m) 
	{
		m.setId(id++);
		mealPlans.add(m);
	}
	
	/**
	 * Reset the meal plan list and add a few default meal plans
	 */
	public static void resetMealPlans()
	{
		MealPlan m = new MealPlan(
				id++,
				"First Meal Plan ever.",
				new ArrayList<MealPlanItem>(), 
				new ArrayList<Date>(Arrays.asList(new Date(2017, 9, 9), new Date(2017, 9, 10)))
		);
		
		mealPlans = new ArrayList<MealPlan>(Arrays.asList(m));
	}
	
	public static long getId()
	{
		return id;
	}
	
}
