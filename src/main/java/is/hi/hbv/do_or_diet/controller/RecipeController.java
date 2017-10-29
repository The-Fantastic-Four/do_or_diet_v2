
/**
 * RecipieController enables the user to interact with recipies
 * 
 * @author Eiður Örn Gunnarsson eog26@hi.is
 * @author Fannar Þeyr Guðmundsson fthg2@hi.is
 * @author Ragnheiður Ásta Karlsdóttir rak4@hi.is
 */
package is.hi.hbv.do_or_diet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import is.hi.hbv.do_or_diet.model.IngredientQuantity;
import is.hi.hbv.do_or_diet.model.IngredientQuantityWrap;
import is.hi.hbv.do_or_diet.model.IngredientType;
import is.hi.hbv.do_or_diet.model.Recipe;
import is.hi.hbv.do_or_diet.service.IngredientQuantityService;
import is.hi.hbv.do_or_diet.service.IngredientTypeService;
import is.hi.hbv.do_or_diet.service.RecipeService;

@Controller
@RequestMapping("/recipe")
public class RecipeController
{
	// Instance of the recipe service, used to get and create recipes
	@Autowired
	RecipeService recipeService;

	// Instance of the ingredientType service, used to get and save ingredientTypes
	@Autowired
	IngredientTypeService ingredientType;

	// Instance of the ingredientQuantity repository, used to get and save
	// ingredientQuantity
	@Autowired
	IngredientQuantityService ingredientQuantities;

	// Index page for the recipes, shows a list of recipes
	@RequestMapping("")
	public String index(Model model)
	{
		getRecipes(model);
		return "recipe/index";
	}

	/**
	 * Allows for searches within the index page of recipe
	 * 
	 * @param recipeSearchName
	 *            string to be searched for within recipes
	 * @param model
	 *            the model that contains all the necessary information
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String searchForRecipeNameWithinIndex(
			@RequestParam(value = "recipeSearchName", required = true) String recipeSearchName, ModelMap model)
	{
		addRecipesContainingNameToModel(recipeSearchName, model);
		return "recipe/index";
	}

	// Redirects user to recipe Add page
	@RequestMapping(value = "/recipeAdd")
	public String recipeAdd()
	{
		return "recipe/recipeAdd";
	}

	/**
	 * Displays more information about a specific recipe
	 * 
	 * @param recipeId
	 *            is the id of the recipe
	 * @param model
	 *            the model that contains all the necessary information
	 * @return
	 */
	@RequestMapping("/{recipeId}")
	public String showRecipe(@PathVariable(value = "recipeId") long recipeId, ModelMap model)
	{
		model.addAttribute("recipe", recipeService.findRecipe(recipeId));
		return "recipe/show";
	}

	/**
	 * Directs to the searchForRecipe page
	 * 
	 * @return
	 */
	@RequestMapping("/searchForRecipe")
	public String displaySearchForRecipe()
	{
		return "recipe/searchForRecipe";
	}

	/**
	 * Searches for a recipe containing recipeName
	 * 
	 * @param recipeName
	 *            string to be searched for within recipes
	 * @param model
	 *            the model that contains all the necessary information
	 * @return
	 */
	@RequestMapping(value = "/searchForRecipe", method = RequestMethod.POST)
	public String searchForRecipeName(@RequestParam(value = "recipeName", required = true) String recipeName,
			ModelMap model)
	{
		addRecipesContainingNameToModel(recipeName, model);
		return "recipe/index";
	}

	/**
	 * receives array of IngredientQuantityWrap objects from UI, w
	 * 
	 * @RequestBody wrap receives the wrap object which contains name of recipe,
	 *              ingredient, measurements and quantities
	 * 
	 *              IngredientQuantity relies on id of recipe and ingredient.
	 */
	@RequestMapping(value = "/ingredientQuantity", method = RequestMethod.POST)
	public String addIngredientQuantity(@RequestBody IngredientQuantityWrap[] wrapArr)
	{
		IngredientQuantity t = new IngredientQuantity();
		if (doesrecipeExist(wrapArr[0]) == true)
		{
			t.setRecipe(findRecipe(wrapArr[0]));
		}
		else
		{
			t.setRecipe(setNewRecipe(wrapArr[0]));
		}
		for (int i = 0; i < wrapArr.length; i++)
		{
			IngredientQuantityWrap wrap = wrapArr[i];
			if (doesIngredientExist(wrap) == true)
			{
				t.setIngredient(findIngredient(wrap));
			}
			else
			{
				t.setIngredient(setNewIngredient(wrap));
			}
			t.setMeasurement(wrap.getMeasurement());
			t.setQuantity(wrap.getQuantity());
			ingredientQuantities.addIngredientQuantity(t);
		}
		return "recipe/index";
	}

	// gets recipes from recipeRepository and adds to model
	public void getRecipes(Model model)
	{
		List<Recipe> recipeList = recipeService.allRecipes();
		model.addAttribute("recipeList", recipeList);
	}

	// finds existing recipies and checks if this recipe is already in database.
	public boolean doesrecipeExist(IngredientQuantityWrap k)
	{
		boolean exist = false;
		ArrayList<Recipe> listRecipe;
		listRecipe = (ArrayList<Recipe>) recipeService.allRecipes();
		for (Recipe recipe : listRecipe)
		{
			if (recipe.getName().equals(k.getRecipeName()))
			{
				exist = true;
			}
		}

		return exist;
	}

	// find ingredient from database and returns it.
	public IngredientType findIngredient(IngredientQuantityWrap k)
	{
		IngredientType s = new IngredientType();
		List<IngredientType> listIngredientType;
		listIngredientType = ingredientType.allIngredientTypes();
		for (IngredientType ingredientType : listIngredientType)
		{
			if (ingredientType.getName().equals(k.getIngredientName()))
				s = ingredientType;
		}
		return s;
	}

	// finds recipe in IngredientQuantityWrap from database.
	public Recipe findRecipe(IngredientQuantityWrap k)
	{
		ArrayList<Recipe> listRecipe;
		Recipe theRecipe = new Recipe();
		listRecipe = (ArrayList<Recipe>) recipeService.allRecipes();
		for (Recipe recipe : listRecipe)
		{
			if (recipe.getName().equals(k.getRecipeName()))
			{
				theRecipe = recipe;
			}
		}
		return theRecipe;
	}

	// saves recipe from UI to database
	public Recipe setNewRecipe(IngredientQuantityWrap k)
	{
		Recipe newRecipe = new Recipe();
		newRecipe.setName(k.getRecipeName());
		newRecipe.setDirections(k.getDirections());
		newRecipe.setServings(k.getServings());
		recipeService.addRecipe(newRecipe);
		return newRecipe;
	}

	// finds ingredients from database
	public boolean doesIngredientExist(IngredientQuantityWrap k)
	{
		boolean exist = false;
		List<IngredientType> listIngredientType;
		listIngredientType = ingredientType.allIngredientTypes();
		for (IngredientType ingredientType : listIngredientType)
		{
			if (ingredientType.getName().equals(k.getIngredientName()) && (ingredientType.getName() != null))
			{
				exist = true;
			}
		}
		return exist;
	}

	// takes new ingredient and saves it to database
	public IngredientType setNewIngredient(IngredientQuantityWrap l)
	{
		IngredientType ingType = new IngredientType();
		ingType.setName(l.getIngredientName());
		ingredientType.addIngredientType(ingType);
		return ingType;
	}

	/**
	 * Adds the resulting list from search for recipeName to given models variable
	 * "recipeList"
	 * 
	 * @param recipeName
	 *            string to be searched for within recipes
	 * @param model
	 *            that is to be given the resulting list
	 */
	private void addRecipesContainingNameToModel(String recipeName, ModelMap model)
	{
		List<Recipe> recipeList = recipeService.findRecipeContaining(recipeName);
		model.addAttribute("recipeList", recipeList);
	}
}
