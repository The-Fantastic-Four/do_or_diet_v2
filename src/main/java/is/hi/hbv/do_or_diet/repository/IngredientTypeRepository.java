/**
 * IngredientTypeRepositroy keeps a list of Ingredients
 * 
 * @author Fannar Þeyr Guðmundsson fthg2@hi.is
 * @date October 2017
 */

package is.hi.hbv.do_or_diet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import is.hi.hbv.do_or_diet.model.IngredientType;

public interface IngredientTypeRepository extends JpaRepository<IngredientType, Long>
{
	List<IngredientType> findAll();

	IngredientType findOne(Long id);

	@SuppressWarnings("unchecked")
	IngredientType save(IngredientType ingredient);
}
