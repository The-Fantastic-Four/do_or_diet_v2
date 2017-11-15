/**
 * RecipieController enables the user to interact with recipes
 * 
 * @author Eiður Örn Gunnarsson eog26@hi.is
 * @author Fannar Þeyr Guðmundsson fthg2@hi.is
 * @author Ragnheiður Ásta Karlsdóttir rak4@hi.is
 * @date október 2017
 */
package is.hi.hbv.do_or_diet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.ArrayList;
import is.hi.hbv.do_or_diet.model.IngredientQuantity;
import is.hi.hbv.do_or_diet.model.IngredientQuantityWrap;
import is.hi.hbv.do_or_diet.model.IngredientType;
import is.hi.hbv.do_or_diet.model.Recipe;
import is.hi.hbv.do_or_diet.model.User;
import is.hi.hbv.do_or_diet.service.IngredientQuantityService;
import is.hi.hbv.do_or_diet.service.IngredientTypeService;
import is.hi.hbv.do_or_diet.service.RecipeService;
import is.hi.hbv.do_or_diet.service.UserService;

@Controller
@RequestMapping("/recipe")
public class RecipeController
{
	// Instance of the recipe service, used to get and create recipes
	@Autowired
	RecipeService recipeService;
	
	// Instance of the user service, used to manage user accounts
	@Autowired
	UserService userService;

	// Instance of the ingredientType service, used to get and save ingredientTypes
	@Autowired
	IngredientTypeService ingredientType;

	// Instance of the ingredientQuantity repository, used to get and save
	// ingredientQuantity
	@Autowired
	IngredientQuantityService ingredientQuantities;

	// Index page for the recipes, shows a list of recipes
	@RequestMapping("")
	public String index(Model model, Authentication authentication)
	{
		User user = null;
		if(authentication != null)
		{
			user = userService.findUserByEmail(authentication.getName());
		}
		getRecipes(model, user);
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
	 * Adds a recipe to users repository
	 * 
	 * @param recipeId
	 *            is the id of the recipe
	 * @param model
	 *            the model that contains the info
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping("/{recipeId}/own")
	public ModelAndView ownRecipe(@PathVariable(value = "recipeId") long recipeId, ModelMap model,
			Authentication authentication) throws SQLException
	{
		User user = null;
		if(authentication != null)
		{
			user = userService.findUserByEmail(authentication.getName());
		}

		try
		{
			Recipe originalRecipe = recipeService.findRecipe(recipeId);
			Recipe newRecipe = recipeService.ownRecipe(originalRecipe, user);

			newRecipe.setIngredients(ingredientQuantities.copyIngredients(originalRecipe, newRecipe));
		}
		catch (Exception e)
		{
			throw new SQLException("Ekki tókst að finna uppskrift og búa til afrit af henni.");
		}

		return new ModelAndView("redirect:/recipe");
	}

	@RequestMapping("/changeRecipe/{recipeId}")
	public String changeRecipe(@PathVariable(value = "recipeId") long recipeId, ModelMap model)
	{
		model.addAttribute("recipe", recipeService.findRecipe(recipeId));
		return "recipe/changeRecipe";
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

<<<<<<< HEAD
	

	/**
	 * receives array of IngredientQuantityWrap objects from UI, w
	 * 
	 * @RequestBody wrap receives the wrap object which contains recipe which will be changed in database,
	 *              
	 *  
	 *            @param model    the model that contains all the necessary informationt.
	 *              
	 *            @param authentication
	 *             
	 */
=======
	@RequestMapping(value = "/changeRecipe", method = RequestMethod.POST)
	public void changeRecipe(Recipe recipe, ModelMap model)
	{
		System.out.println("Bla");
		// model.addAttribute(recipe);
		// return "recipe/changeRecipe";
	}

>>>>>>> branch 'master' of https://github.com/The-Fantastic-Four/do_or_diet_v2.git
	@RequestMapping(value = "/changeRecipe/save", method = RequestMethod.POST)
	public ModelAndView changeIngredientQuantity(@RequestBody IngredientQuantityWrap[] wrapArr, Model model, Authentication authentication)
	{
		User user = userService.findUserByEmail(authentication.getName());
		Recipe th = recipeService.findRecipe(wrapArr[0].getRecipeId());

		if (th.getCreatedBy() != user)
		{
			throw new AccessDeniedException("Innskráður notandi hefur ekki aðgang að þessari uppskrift, bættu henni í þínar uppskriftir og reyndu aftur");
		}
		ingredientQuantities.deleteIngredientQuantity(wrapArr[0].getRecipeId());
				
		Recipe chRecipe = new Recipe();
		chRecipe.setId(wrapArr[0].getRecipeId());
		chRecipe.setName(wrapArr[0].getRecipeName());
		chRecipe.setCreatedBy(user);
		chRecipe.setDirections(wrapArr[0].getDirections());
		chRecipe.setServings(wrapArr[0].getServings());
		chRecipe.setPrivate(false);
		recipeService.addRecipe(chRecipe);
		for (int i = 0; i < wrapArr.length; i++)
		{
			IngredientQuantity t = new IngredientQuantity();
			t.setRecipe(chRecipe);
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
			t.setQuantity(Double.parseDouble(wrap.getQuantity()));
			ingredientQuantities.addIngredientQuantity(t);
		}
		return new ModelAndView("redirect:/recipe");
	}

	/**
	 * @RequestBody wrap receives the wrap object which contains name of recipe,
	 *              ingredient, measurements and quantities
	 * 
	 *              IngredientQuantity relies on id of recipe and ingredient.
	 */
	@RequestMapping(value = "/ingredientQuantity", method = RequestMethod.POST)
	public ModelAndView addIngredientQuantity(@RequestBody IngredientQuantityWrap[] wrapArr, Model model, Authentication authentication)
	{
		User user = null;
		if (authentication != null)
		{
			user = userService.findUserByEmail(authentication.getName());
		}

		for (int i = 0; i < wrapArr.length; i++)
		{
			IngredientQuantity t = new IngredientQuantity();
			if (doesrecipeExist(wrapArr[i]) == true)
			{
				t.setRecipe(findRecipe(wrapArr[0]));
			}
			else
			{
				t.setRecipe(setNewRecipe(wrapArr[0], user));
			}
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
			t.setQuantity(Double.parseDouble(wrap.getQuantity()));
			ingredientQuantities.addIngredientQuantity(t);
		}

		return new ModelAndView("redirect:/recipe");
	}

	// gets recipes from recipeRepository and adds to model
	public void getRecipes(Model model, User user)
	{
		List<Recipe> recipeList = recipeService.allRecipes();
		model.addAttribute("recipeList", recipeList);

		if (user != null)
		{
			List<Recipe> myRecipeList = recipeService.myRecipes(user);
			model.addAttribute("myRecipeList", myRecipeList);
		}
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
	public Recipe setNewRecipe(IngredientQuantityWrap k, User user)
	{
		Recipe newRecipe = new Recipe();
		newRecipe.setName(k.getRecipeName());
		newRecipe.setDirections(k.getDirections());
		newRecipe.setServings(k.getServings());
		newRecipe.setPrivate(false);
		newRecipe.setCreatedBy(user);
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
