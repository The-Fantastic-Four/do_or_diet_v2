package is.hi.hbv.do_or_diet.service;

import java.util.List;

import is.hi.hbv.do_or_diet.model.MealPlan;
import is.hi.hbv.do_or_diet.model.ShoppingList;
import is.hi.hbv.do_or_diet.model.User;

public interface ShoppingListService
{
	/**
	 * Create a new shopping list from a meal plan
	 * 
	 * @param mealPlan
	 *            the meal plan to create the list from
	 * @param owner
	 *            the owner of the shopping list
	 * @return the newly created shopping list
	 */
	public ShoppingList createFromMealPlan(MealPlan mealPlan, User owner);

	/**
	 * Find all shopping lists which the user owns
	 * 
	 * @param owner
	 *            owner of the shopping lists
	 * @return a list of shopping lists
	 */
	public List<ShoppingList> allShoppingLists(User owner);

	/**
	 * Find a specific shopping list
	 * 
	 * @param id
	 *            the id of the shopping list
	 * @return the shopping list
	 */
	public ShoppingList findShoppingList(long id);
}
