package is.hi.hbv.do_or_diet.model;

import java.util.Date;

/**
 * Wrapper for MealPlanItems
 * 
 * @author Eiður Örn Gunnarsson eog26@hi.is
 * @date 16. okt. 2017
 */
public class MealPlanItemWrapper
{
	private MealPlan mealPlan;
	private Recipe recipe;
	private Date date;

	/**
	 * Constructor for the MealPlanItemWrapper
	 * 
	 * @param mealPlan
	 *            meal plan to be stored
	 * @param recipe
	 *            recipe to be stored
	 * @param date
	 *            date to be stored
	 */
	public MealPlanItemWrapper(MealPlan mealPlan, Recipe recipe, Date date)
	{
		this.mealPlan = mealPlan;
		this.recipe = recipe;
		this.date = date;
	}

	public MealPlan getMealPlan()
	{
		return mealPlan;
	}

	public Recipe getRecipe()
	{
		return recipe;
	}

	public Date getDate()
	{
		return date;
	}

}
