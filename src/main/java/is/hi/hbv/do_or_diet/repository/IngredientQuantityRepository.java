/**
 * IngredientQuantityRepository keeps a list of Ingredients
 * 
 * @author Fannar Þeyr Guðmundsson fthg2@hi.is
 * @date October 2017
 */
package is.hi.hbv.do_or_diet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import is.hi.hbv.do_or_diet.model.IngredientQuantity;

public interface IngredientQuantityRepository extends JpaRepository<IngredientQuantity, Long>
{
	List<IngredientQuantity> findAll();

	IngredientQuantity findOne(Long id);

	@SuppressWarnings("unchecked")
	IngredientQuantity save(IngredientQuantity ingredientQ);

	@Transactional
	Long deleteByrecipe_id(Long id);
}
