package is.hi.hbv.do_or_diet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import is.hi.hbv.do_or_diet.model.Recipe;
import is.hi.hbv.do_or_diet.repository.RecipeRepository;

@Service
public class RecipeService {
	@Autowired
	RecipeRepository recipesRep;
	
public void addRecipe(Recipe r) {
	recipesRep.addRecipes(r);
}
	
}


