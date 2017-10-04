	/**
	 * IngredientTypeRepositroy keeps a list of Ingredients
	 * @author Fannar Þeyr Guðmundsson fthg2@hi.is
	 */

package is.hi.hbv.do_or_diet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import is.hi.hbv.do_or_diet.model.IngredientQuantity;


public interface IngredientQuantityRepository extends JpaRepository<IngredientQuantity, Long> 
{
	    List<IngredientQuantity> findAll();
	    
	    IngredientQuantity findOne(Long id);
	    
	    IngredientQuantity save(IngredientQuantity ingredientQ);
}
