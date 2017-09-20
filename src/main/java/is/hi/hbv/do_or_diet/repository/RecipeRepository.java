/**
 * RecipeRepository keeps a list of recipies
 * @author Ragnheiður Ásta Karlsdóttir rak4@hi.is
 * @author Viktor Alex Brynjarsson vab18@hi.is
 */
package is.hi.hbv.do_or_diet.repository;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Repository;

import is.hi.hbv.do_or_diet.model.Recipe;

/**
 * Prufu komment til að framkalla merge villu
 * @author viktoralex
 *
 */
@Repository
public class RecipeRepository 
{
	/**
	 * List of recipes
	 */
	private static ArrayList<Recipe> recipes;

	public ArrayList<Recipe> getRecipes() 
	{
		return recipes;
	}

	/**
	 * Add a new recipe to the repository
	 * @param r the recipe to be added
	 */
	public void addRecipes(Recipe r) 
	{
		RecipeRepository.recipes.add(r);
	}
	
	/**
	 * Reset the recipe list and add a few default recipes
	 */
	public static void resetRecipes()
	{
		Recipe r1 = new Recipe(0, "Tikka masala", null, null, 2, null);
		Recipe r2 = new Recipe(1, "Pasta", null, null, 2, null);
		Recipe r3 = new Recipe(2, "Bananar", null, null, 2, null);
		Recipe r4 = new Recipe(3, "Bakaðar kartöflur", null, null, 2, null);
		
		recipes = new ArrayList<Recipe>(Arrays.asList(r1, r2, r3, r4));
	}
}
