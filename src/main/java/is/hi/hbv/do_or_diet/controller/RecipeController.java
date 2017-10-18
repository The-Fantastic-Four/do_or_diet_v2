
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
import java.util.ArrayList;
import is.hi.hbv.do_or_diet.model.IngredientQuantity;
import is.hi.hbv.do_or_diet.model.IngredientQuantityWrap;
import is.hi.hbv.do_or_diet.model.IngredientType;
import is.hi.hbv.do_or_diet.model.Recipe;
import is.hi.hbv.do_or_diet.repository.IngredientTypeRepository;
import is.hi.hbv.do_or_diet.service.IngredientTypeService;
import is.hi.hbv.do_or_diet.service.RecipeService;
import is.hi.hbv.do_or_diet.repository.IngredientQuantityRepository;

@Controller
@RequestMapping("/recipe")
public class RecipeController
{
	// Instance of the recipe service, used to get and create recipes
	@Autowired
	RecipeService recipeService;

	// Instance of the ingredientType service, used to get and save ingredientTypes
	@Autowired
	IngredientTypeRepository ingredientTypes;
	
	@Autowired
	IngredientTypeService ingredientService;

	// Instance of the ingredientQuantity repository, used to get and save ingredientQuantity
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

	/** receives recipe from UI and saves into repository and then into database.
	*   
	* @RequestBody recipe
	*            receives the recipe object which contains name, directions, servings and Id
	* @param model
	*            the model that contains all the necessary information
	*/
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String recipeRoute(@RequestBody Recipe recipe, Model model)
	{
		recipeService.addRecipe(recipe);
		return "recipe/index";
	}
	
	/** receives object of type IngredientQuantityWrap from UI, w
	*   
	* @RequestBody wrap
	*            receives the wrap object which contains name of recipe, ingredient, measurements and quantities 
	*            
	* @param model
	*            the model that contains all the necessary information
	*  
	* IngredientQuantity relies on id of recipe and ingredient. 
	*/
	@RequestMapping(value = "/ingredientQuantity", method = RequestMethod.POST)
	public String addIngredientQuantity(@RequestBody IngredientQuantityWrap wrap, Model model)
	{	
		IngredientQuantity t = new IngredientQuantity();
		ArrayList < Recipe > listRecipe;
		listRecipe = (ArrayList < Recipe >) recipeService.allRecipes();		
		for(Recipe recipe : listRecipe)
		{
			if(recipe.getName().equals(wrap.getRecipeName())) 
			{
				t.setRecipe(recipe);
			}	
		}
				
		boolean ingredientExists = false;
		List<IngredientType> listIngredientType;
		listIngredientType = ingredientService.allIngredientTypes();
		for(IngredientType ingredientType : listIngredientType)
		{
			System.out.println(ingredientType.getName());
			if(ingredientType.getName().equals(wrap.getIngredientName()))
				t.setIngredient(ingredientType);
				ingredientExists = true;
		}
		if (!ingredientExists)
		{
			IngredientType IngType = new IngredientType();
			IngType.setName(wrap.getIngredientName());
			ingredientTypes.save(IngType);
			for(IngredientType ingredientType : listIngredientType)
			{
				if(ingredientType.getName().equals(wrap.getIngredientName()))
					t.setIngredient(ingredientType);
					ingredientExists = true;
			}
		}
		
		t.setMeasurement(wrap.getMeasurement());
		t.setQuantity(wrap.getQuantity());
		ingredientQuantities.save(t);
		return "recipe/index";
	}

	// gets recipes from recipeRepository and adds to model
	public void getRecipes(Model model)
	{
		List<Recipe> recipeList = recipeService.allRecipes();
		model.addAttribute("recipeList", recipeList);
	}
}
