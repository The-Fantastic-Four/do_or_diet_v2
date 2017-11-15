/**
 * Service that connects to the meal plan item repository and checks if meal
 * plan already exists within meal plan and handles that.
 * 
 * @author Eiður Örn Gunnarsson eog26@hi.is
 * @date 16. okt. 2017
 */
package is.hi.hbv.do_or_diet.service;

import is.hi.hbv.do_or_diet.model.MealPlanItemWrapper;

public interface MealPlanItemService
{
	/**
	 * Adds the meal plan to the meal plan repository if it doesn't exist, otherwise
	 * modify the meal plan item to fit new needs.
	 * 
	 * @param m
	 *            meal plan item wrapper containing required information
	 */
	public void addMealPlanItem(MealPlanItemWrapper m);
}