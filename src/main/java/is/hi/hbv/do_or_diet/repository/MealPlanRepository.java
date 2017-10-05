/**
 * MealPlanRepository keeps a list of meal plans
 * 
 * @author Eiður Örn Gunnarsson eog26@hi.is
 */
package is.hi.hbv.do_or_diet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import is.hi.hbv.do_or_diet.model.MealPlan;

public interface MealPlanRepository extends JpaRepository<MealPlan, Long>
{

	List<MealPlan> findAll();

	MealPlan findOne(Long id);

	// Suppressed as teacher had same warning and had not fixed it
	@SuppressWarnings("unchecked")
	MealPlan save(MealPlan recipe);
}
