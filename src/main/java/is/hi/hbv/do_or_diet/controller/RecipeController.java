/**
 * RecipieController enables the user to interact with recipies
 * @author Fannar Þeyr Guðmundsson fthg2@hi.is
 * @author Ragnheiður Ásta Karlsdóttir rak4@hi.is
 */
package is.hi.hbv.do_or_diet.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
		ArrayList<Recipe> recipeList = recipes.getRecipes();
		model.addAttribute("recipeList", recipeList);
		return "recipe/index";
	}
}
