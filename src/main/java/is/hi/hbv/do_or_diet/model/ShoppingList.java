package is.hi.hbv.do_or_diet.model;

import java.util.ArrayList;

public class ShoppingList {
	private long id;
	private ArrayList<ShoppingListItem> items;
	private MealPlan mealPlan;

	public ShoppingList(long id, ArrayList<ShoppingListItem> items, MealPlan mealPlan) {
		this.id = id;
		this.items = items;
		this.mealPlan = mealPlan;
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
	 * @return the items
	 */
	public ArrayList<ShoppingListItem> getItems() {
		return items;
	}

	/**
	 * @param items
	 *            is the variable to set items
	 */
	public void setItems(ArrayList<ShoppingListItem> items) {
		this.items = items;
	}

	/**
	 * @return the mealPlan
	 */
	public MealPlan getMealPlan() {
		return mealPlan;
	}

	/**
	 * @param mealPlan
	 *            is the variable to set mealPlan
	 */
	public void setMealPlan(MealPlan mealPlan) {
		this.mealPlan = mealPlan;
	}
}
