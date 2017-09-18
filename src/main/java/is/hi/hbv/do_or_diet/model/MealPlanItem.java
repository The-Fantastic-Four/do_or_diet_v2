package is.hi.hbv.do_or_diet.model;

import java.util.Date;

public class MealPlanItem {
	private long id;
	private Recipe recipe;
	private Date date;
	private MealType mealType;

	public MealPlanItem(long id, Recipe recipe, Date date, MealType mealType) {
		this.id = id;
		this.recipe = recipe;
		this.date = date;
		this.mealType = mealType;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            is the variable to set id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the recipe
	 */
	public Recipe getRecipe() {
		return recipe;
	}

	/**
	 * @param recipe
	 *            is the variable to set recipe
	 */
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            is the variable to set date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the mealType
	 */
	public MealType getMealType() {
		return mealType;
	}

	/**
	 * @param mealType
	 *            is the variable to set mealType
	 */
	public void setMealType(MealType mealType) {
		this.mealType = mealType;
	}
}
