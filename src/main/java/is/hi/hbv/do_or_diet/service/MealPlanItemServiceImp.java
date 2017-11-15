/**
 * @author Eiður Örn Gunnarsson eog26@hi.is
 * @date 16. okt. 2017
 */
package is.hi.hbv.do_or_diet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import is.hi.hbv.do_or_diet.model.MealPlan;
import is.hi.hbv.do_or_diet.model.MealPlanItem;
import is.hi.hbv.do_or_diet.model.MealPlanItemWrapper;
import is.hi.hbv.do_or_diet.model.MealType;
import is.hi.hbv.do_or_diet.model.Recipe;
import is.hi.hbv.do_or_diet.repository.MealPlanItemRepository;

@Service
public class MealPlanItemServiceImp implements MealPlanItemService
{

	@Autowired
	MealPlanItemRepository mealPlanItemRep;

	@Override
	@Transactional
	public void addMealPlanItem(MealPlanItemWrapper m)
	{
		MealPlan mealPlan = m.getMealPlan();
		Recipe newRecipe = m.getRecipe();

		boolean mealExists = false;
		for (MealPlanItem mealItem : mealPlan.getItems())
		{
			if (mealItem.getDate() == m.getDate())
			{
				mealItem.setRecipe(newRecipe);
				mealPlanItemRep.save(mealItem);
				mealExists = true;
			}
		}

		if (!mealExists)
		{
			MealPlanItem newItem = new MealPlanItem();
			newItem.setDate(m.getDate());
			newItem.setRecipe(newRecipe);
			newItem.setMealType(MealType.DINNER);
			newItem.setMealPlan(mealPlan);
			mealPlanItemRep.save(newItem);
		}

	}

}
