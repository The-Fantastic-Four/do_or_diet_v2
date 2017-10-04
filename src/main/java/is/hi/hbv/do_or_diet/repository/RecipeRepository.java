/**
 * RecipeRepository keeps a list of recipes
 * @author Ragnheiður Ásta Karlsdóttir rak4@hi.is
 * @author Viktor Alex Brynjarsson vab18@hi.is
 */
package is.hi.hbv.do_or_diet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import is.hi.hbv.do_or_diet.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> 
{
	
    List<Recipe> findAll();
    
    // Suppressed as teacher had same warning and had not fixed
    @SuppressWarnings("unchecked")
	Recipe save(Recipe recipe);
	
}
