/**
 * Service that connects to the ingredient quantity repository
 * 
 * @author Eiður Örn Gunnarsson eog26@hi.is
 * @date 16. okt. 2017
 */
package is.hi.hbv.do_or_diet.service;

import java.util.List;

import is.hi.hbv.do_or_diet.model.IngredientQuantity;
import is.hi.hbv.do_or_diet.model.Recipe;

public interface IngredientQuantityService
{
	/**
	 * Adds an ingredient quantity to the ingredient quantity repository
	 * 
	 * @param ingQ
	 *            ingredient quantity to be added
	 */
	public void addIngredientQuantity(IngredientQuantity ingrQuantity);

	/**
	 * Deletes Ingredient information from a recipe
	 * 
	 * @param id
	 *            of the recipe containing ingredientQuantity to be deleted
	 */
	public void deleteIngredientQuantity(long id);

	/**
	 * Fetches all of the ingredient quantities from repository
	 * 
	 * @return list of ingredient quantities
	 */
	public List<IngredientQuantity> allIngredientQuantities();

	/**
	 * Finds an ingredient quantity from ingredient quantity ID
	 * 
	 * @param id
	 *            of ingredient quantity
	 * @return ingredient quantity with appropriate ID
	 */
	public IngredientQuantity findIngredientQuantity(long id);

	/**
	 * Copies a recipes ingredients to a new recipe
	 * 
	 * @param originalRecipe
	 *            the recipe to be copied
	 * @param newRecipe
	 *            the recipe that is the copy
	 * @return
	 */
	public List<IngredientQuantity> copyIngredients(Recipe originalRecipe, Recipe newRecipe);
}
