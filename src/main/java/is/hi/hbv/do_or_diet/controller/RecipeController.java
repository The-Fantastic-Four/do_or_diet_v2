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
	@Autowired
	RecipeRepository recipes;
	@RequestMapping("")
	public String index(Model model)
	{
		ArrayList<Recipe> recipeList = recipes.getRecipes();
		model.addAttribute("recipeList", recipeList);
		return "recipe/index";
	}
}
