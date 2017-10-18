package is.hi.hbv.do_or_diet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import is.hi.hbv.do_or_diet.model.Recipe;
import is.hi.hbv.do_or_diet.repository.RecipeRepository;

/**
 * @author Eiður Örn Gunnarsson eog26@hi.is
 * @date 16. okt. 2017
 */
@Service
public class RecipeServiceImp implements RecipeService
{
	@Autowired
	RecipeRepository recipeRep;

	@Override
	public void addRecipe(Recipe r)
	{
		recipeRep.save(r);
	}

	@Override
	public List<Recipe> allRecipes()
	{
		return recipeRep.findAll();
	}

	@Override
	public Recipe findRecipe(long id)
	{
		return recipeRep.findOne(id);
	}

}