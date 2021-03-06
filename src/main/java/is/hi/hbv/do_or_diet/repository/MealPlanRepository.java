/**
 * MealPlanRepository keeps a list of meal plans
 * 
 * @author Eiður Örn Gunnarsson eog26@hi.is
 * @date 13. nov. 2017
 */
package is.hi.hbv.do_or_diet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import is.hi.hbv.do_or_diet.model.MealPlan;
import is.hi.hbv.do_or_diet.model.User;

public interface MealPlanRepository extends JpaRepository<MealPlan, Long>
{

	List<MealPlan> findAll();

	List<MealPlan> findByCreatedBy(User creator);

	MealPlan findOne(Long id);

	@Transactional
	Long deleteById(Long id);

	// Suppressed as teacher had same warning and had not fixed it
	@SuppressWarnings("unchecked")
	MealPlan save(MealPlan m);
}
