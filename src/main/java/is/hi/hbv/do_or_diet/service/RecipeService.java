package is.hi.hbv.do_or_diet.service;

import java.util.List;

import javax.transaction.Transactional;

import is.hi.hbv.do_or_diet.model.Recipe;

/**
 * Service that connects to the recipe repository
 * 
 * @author Eiður Örn Gunnarsson eog26@hi.is
 * @date 29. okt. 2017
 */
public interface RecipeService
{
	/**
	 * Adds a recipe to the recipe repository
	 * 
	 * @param r
	 */

	public void addRecipe(Recipe r);

	/**
	 * Fetches all of the recipes from repository
	 * 
	 * @return list of all recipes
	 */
	public List<Recipe> allRecipes();

	/**
	 * Fetches all recipes containing recipeName
	 * 
	 * @param recipeName
	 *            name of recipe to be searched for
	 * @return list of all recipes containing the recipeName string
	 */
	public List<Recipe> findRecipeContaining(String recipeName);

	/**
	 * Finds a recipe in repository from recipe ID
	 * 
	 * @param id
	 *            of recipe
	 * @return recipe with the appropriate ID
	 */
	public Recipe findRecipe(long id);
}
