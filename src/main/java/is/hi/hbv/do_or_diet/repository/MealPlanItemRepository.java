/**
 * Saves meal plan items. They should only be fetched through the MealPlanRepostory.
 * @author Viktor Alex Brynjarsson vab18@hi.is
 */
package is.hi.hbv.do_or_diet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import is.hi.hbv.do_or_diet.model.MealPlanItem;

public interface MealPlanItemRepository extends JpaRepository<MealPlanItem, Long>
{

	// Supressed as teacher had same warning and had not fixed it
    @SuppressWarnings("unchecked")
	MealPlanItem save(MealPlanItem mealPlanItem);
}
