/**
 * RecipieController enables the user to interact with recipies
 * @author Fannar Þeyr Guðmundsson fthg2@hi.is
 * @author Ragnheiður Ásta Karlsdóttir rak4@hi.is
 */
package is.hi.hbv.do_or_diet.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import is.hi.hbv.do_or_diet.model.MealPlanItem;
import is.hi.hbv.do_or_diet.model.MealType;
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
	@RequestMapping(value = "/recipeAdd")
	public String recipeAdd() {		
		return "recipe/recipeAdd";
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String recipeRoute() 
	{
		System.out.println("HALLO FRA CONTROLER : ");
			/*Recipe recipe = new Recipe();
			recipe.setName(Request.);
			*/
		return "recipe/index";
	}
}
