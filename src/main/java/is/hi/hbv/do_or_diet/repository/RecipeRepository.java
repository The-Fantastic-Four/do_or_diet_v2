/**
 * RecipeRepository keeps a list of recipes
 * 
 * @author Ragnheiður Ásta Karlsdóttir rak4@hi.is
 * @author Viktor Alex Brynjarsson vab18@hi.is
 * @date October 2017
 */
package is.hi.hbv.do_or_diet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import is.hi.hbv.do_or_diet.model.Recipe;
import is.hi.hbv.do_or_diet.model.User;

public interface RecipeRepository extends JpaRepository<Recipe, Long>
{

	List<Recipe> findAllByOrderByNameAsc();

	Recipe findOne(Long id);

	List<Recipe> findByNameContainingIgnoreCaseAndIsPrivateFalse(String recipeName);

	List<Recipe> findByCreatedByOrderByNameAsc(User creator);

	List<Recipe> findByIsPrivateFalseOrderByNameAsc();

	// Suppressed as teacher had same warning and had not fixed it
	@SuppressWarnings("unchecked")
	Recipe save(Recipe recipe);
}
