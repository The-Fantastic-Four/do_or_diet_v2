/**
 * Describes a shopping list created from a meal plan
 * @author Eiður Örn Gunnarsson eog26@hi.is
 */
package is.hi.hbv.do_or_diet.model;

import java.util.ArrayList;

public class ShoppingList {
	
	/**
	 * Unique identifier for this shopping list
	 */
	private long id;
	
	/**
	 * List of items on this shopping list
	 */
	private ArrayList<ShoppingListItem> items;
	
	/**
	 * The meal plan this shopping list was created from
	 */
	private MealPlan mealPlan;

	/**
	 * Create a new shopping list
	 * @param id unique identifier for this shopping list
	 * @param items the items on this shopping list
	 * @param mealPlan the meal plan this shopping list was created from
	 */
	public ShoppingList(long id, ArrayList<ShoppingListItem> items, MealPlan mealPlan) {
		this.id = id;
		this.items = items;
		this.mealPlan = mealPlan;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ArrayList<ShoppingListItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<ShoppingListItem> items) {
		this.items = items;
	}

	public MealPlan getMealPlan() {
		return mealPlan;
	}

	public void setMealPlan(MealPlan mealPlan) {
		this.mealPlan = mealPlan;
	}
}
