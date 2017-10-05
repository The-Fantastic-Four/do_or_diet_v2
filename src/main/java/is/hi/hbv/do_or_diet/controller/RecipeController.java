/**
 * RecipieController enables the user to interact with recipies
 * 
 * @author Fannar Þeyr Guðmundsson fthg2@hi.is
 * @author Ragnheiður Ásta Karlsdóttir rak4@hi.is
 */
package is.hi.hbv.do_or_diet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import is.hi.hbv.do_or_diet.model.IngredientQuantity;
import is.hi.hbv.do_or_diet.model.IngredientType;
import is.hi.hbv.do_or_diet.model.Recipe;
import is.hi.hbv.do_or_diet.repository.IngredientTypeRepository;
import is.hi.hbv.do_or_diet.repository.RecipeRepository;
import is.hi.hbv.do_or_diet.repository.IngredientQuantityRepository;

@Controller
@RequestMapping("/recipe")
public class RecipeController
{
	// Instance of the recipe repository, used to get and create recipes
	@Autowired
	RecipeRepository recipes;

	@Autowired
	IngredientTypeRepository ingredientTypes;

	@Autowired
	IngredientQuantityRepository ingredientQuantities;

	// Index page for the recipes, shows a list of recipes
	@RequestMapping("")
	public String index(Model model)
	{
		getRecipes(model);
		return "recipe/index";
	}

	// Redirects user to recipe Add page
	@RequestMapping(value = "/recipeAdd")
	public String recipeAdd()
	{
		return "recipe/recipeAdd";
	}

	// receives recipe from UI and saves into repository and then into database.
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String recipeRoute(@RequestBody Recipe recipe, Model model)
	{
		recipes.save(recipe);
		return "recipe/index";
	}

	// receives ingredient name from UI and is saved with Id into database
	@RequestMapping(value = "/ingredientType", method = RequestMethod.POST)
	public long addIngredientType(@RequestBody IngredientType ingredientType, Model model)
	{
		IngredientType t = ingredientTypes.save(ingredientType);
		return t.getId();
	}

	// receives ingredientQuantity from UI and sends into database
	@RequestMapping(value = "/ingredientQuantity", method = RequestMethod.POST)
	public long addIngredientQuantity(@RequestBody IngredientQuantity ingredientQuantity, Model model)
	{

		IngredientQuantity t = ingredientQuantities.save(ingredientQuantity);
		return t.getId();
	}

	// gets recipes from recipeRepository and adds to model
	public void getRecipes(Model model)
	{
		List<Recipe> recipeList = recipes.findAll();
		model.addAttribute("recipeList", recipeList);
	}
}
