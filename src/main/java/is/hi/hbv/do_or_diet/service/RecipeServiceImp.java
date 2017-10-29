package is.hi.hbv.do_or_diet.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import is.hi.hbv.do_or_diet.model.Recipe;
import is.hi.hbv.do_or_diet.repository.RecipeRepository;

/**
 * @author Eiður Örn Gunnarsson eog26@hi.is
 * @date 29. okt. 2017
 */
@Service
public class RecipeServiceImp implements RecipeService
{
	@Autowired
	RecipeRepository recipeRep;

	@Transactional
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
	public List<Recipe> findRecipeContaining(String recipeName)
	{
		return recipeRep.findByNameContaining(recipeName);
	}

	@Override
	public Recipe findRecipe(long id)
	{
		return recipeRep.findOne(id);
	}

}
