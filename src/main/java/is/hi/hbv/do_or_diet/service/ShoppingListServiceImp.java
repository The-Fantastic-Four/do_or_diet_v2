/**
 * ShoppingListServiceImp implements interaction with shopping list from repository
 * 
 * @author Viktor Alex Brynjarsson vab18@hi.is
 * @date October 2017
 */
package is.hi.hbv.do_or_diet.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import is.hi.hbv.do_or_diet.model.IngredientQuantity;
import is.hi.hbv.do_or_diet.model.MealPlan;
import is.hi.hbv.do_or_diet.model.MealPlanItem;
import is.hi.hbv.do_or_diet.model.ShoppingList;
import is.hi.hbv.do_or_diet.model.ShoppingListItem;
import is.hi.hbv.do_or_diet.model.User;
import is.hi.hbv.do_or_diet.repository.ShoppingListItemRepository;
import is.hi.hbv.do_or_diet.repository.ShoppingListRepository;

@Service
public class ShoppingListServiceImp implements ShoppingListService
{
	@Autowired
	ShoppingListRepository shoppingListRepository;

	@Autowired
	ShoppingListItemRepository shoppingListItemRepository;

	@Override
	public ShoppingList createFromMealPlan(MealPlan mealPlan, User owner)
	{
		ShoppingList sl = new ShoppingList();
		sl.setOwner(owner);
		sl.setMealPlan(mealPlan);
		sl = shoppingListRepository.save(sl);

		HashMap<String, ShoppingListItem> items = new HashMap<>();
		for (MealPlanItem mealPlanItem : mealPlan.getItems())
		{
			if (mealPlanItem.getRecipe() == null || mealPlanItem.getRecipe().getIngredients() == null)
				continue;

			for (IngredientQuantity ingredient : mealPlanItem.getRecipe().getIngredients())
			{
				if (ingredient.getIngredient() == null)
					continue;

				String ingredientName = ingredient.getIngredient().getName();
				String hashKey = ingredientName + ingredient.getMeasurement();

				ShoppingListItem item = null;
				if (items.containsKey(hashKey))
					item = items.get(hashKey);
				else
					item = new ShoppingListItem();

				item.setAmount(item.getAmount() + ingredient.getQuantity());
				item.setChecked(false);
				item.setItemName(ingredient.getIngredient().getName());
				item.setMeasurement(ingredient.getMeasurement());
				item.setShoppingList(sl);

				items.put(hashKey, item);
			}
		}
		List<ShoppingListItem> itemList = shoppingListItemRepository.save(items.values());
		sl.setItems(itemList);

		return sl;
	}

	@Override
	public List<ShoppingList> allShoppingLists(User owner)
	{
		return shoppingListRepository.findByOwner(owner);
	}

	@Override
	public ShoppingList findShoppingList(long id)
	{
		return shoppingListRepository.findOne(id);
	}

	@Override
	public void toggleShoppingListItem(long id)
	{
		ShoppingListItem item = shoppingListItemRepository.findOne(id);
		item.setChecked(!item.isChecked());
		shoppingListItemRepository.save(item);
	}
}
