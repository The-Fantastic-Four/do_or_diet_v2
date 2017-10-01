/**
 * RecipieController enables the user to interact with recipies
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

import is.hi.hbv.do_or_diet.model.Recipe;
import is.hi.hbv.do_or_diet.repository.RecipeRepository;

@Controller
@RequestMapping("/recipe")
public class RecipeController 
{
	// Instance of the recipe repository, used to get and create recipes
	@Autowired
	RecipeRepository recipes;
	
	// Index page for the recipes, shows a list of recipes
	@RequestMapping("")
	public String index(Model model)
	{
		getRecipes(model);
		return "recipe/index";
	}
	@RequestMapping(value = "/recipeAdd")
	public String recipeAdd() {		
		return "recipe/recipeAdd";
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String recipeRoute(@RequestBody Recipe recipe, Model model) 
	{	
		recipes.save(recipe);
		
		getRecipes(model);
		return "recipe/index";
	}
	
	public void getRecipes(Model model)
	{
		List<Recipe> recipeList = recipes.findAll();
		model.addAttribute("recipeList", recipeList);
	}
}
