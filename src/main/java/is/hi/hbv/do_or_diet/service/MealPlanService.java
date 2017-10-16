package is.hi.hbv.do_or_diet.service;

import java.util.List;

import is.hi.hbv.do_or_diet.model.MealPlan;

/**
 * Service that connects to the meal plan repository
 * 
 * @author Eiður Örn Gunnarsson eog26@hi.is
 * @date 16. okt. 2017
 */
public interface MealPlanService
{
	/**
	 * Adds a meal plan to the meal plan repository
	 * 
	 * @param m
	 *            meal plan to be added
	 */
	public void addMealPlan(MealPlan m);

	/**
	 * Fetches all of the meal plans from repository
	 * 
	 * @return list of meal plans
	 */
	public List<MealPlan> allMealPlans();

	/**
	 * Finds a meal plan in repository from meal plan ID
	 * 
	 * @param id of meal plan
	 * @return meal plan with the appropriate ID
	 */
	public MealPlan findMealPlan(long id);
}
