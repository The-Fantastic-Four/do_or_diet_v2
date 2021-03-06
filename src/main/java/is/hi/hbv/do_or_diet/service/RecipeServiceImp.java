/**
 * RecipeServiceImp implements interactions with the recipe repository
 * @author Eiður Örn Gunnarsson eog26@hi.is
 * @date 29. okt. 2017
 */
package is.hi.hbv.do_or_diet.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import is.hi.hbv.do_or_diet.model.Recipe;
import is.hi.hbv.do_or_diet.model.User;
import is.hi.hbv.do_or_diet.repository.RecipeRepository;

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
		return recipeRep.findByIsPrivateFalseOrderByNameAsc();
	}

	@Override
	public List<Recipe> myRecipes(User user)
	{
		return recipeRep.findByCreatedByOrderByNameAsc(user);
	}

	@Override
	public List<Recipe> findRecipeContaining(String recipeName)
	{
		return recipeRep.findByNameContainingIgnoreCaseAndIsPrivateFalse(recipeName);
	}

	@Override
	public Recipe findRecipe(long id)
	{
		return recipeRep.findOne(id);
	}

	@Override
	public Recipe ownRecipe(Recipe originalRecipe, User newOwner)
	{
		Recipe newRecipe = new Recipe();

		newRecipe.setCategories(new ArrayList<String>(originalRecipe.getCategories()));
		newRecipe.setDirections(originalRecipe.getDirections());
		newRecipe.setName(originalRecipe.getName());
		newRecipe.setServings(originalRecipe.getServings());

		newRecipe.setPrivate(true);
		newRecipe.setCreatedBy(newOwner);

		this.addRecipe(newRecipe);

		return newRecipe;
	}
}
