package is.hi.hbv.do_or_diet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import is.hi.hbv.do_or_diet.model.MealPlan;
import is.hi.hbv.do_or_diet.model.User;
import is.hi.hbv.do_or_diet.repository.MealPlanRepository;

/**
 * @author Eiður Örn Gunnarsson eog26@hi.is
 * @date 13. nov. 2017
 */
@Service
public class MealPlanServiceImp implements MealPlanService
{

	@Autowired
	MealPlanRepository mealPlanRep;

	@Override
	public void addMealPlan(MealPlan m)
	{
		mealPlanRep.save(m);
	}

	@Override
	public List<MealPlan> allMealPlans(User user)
	{
		return mealPlanRep.findByCreatedBy(user);
	}
	
	@Override
	public void deleteMealPlan(long id)
	{
		mealPlanRep.deleteById(id);
	}

	@Override
	public MealPlan findMealPlan(long id)
	{
		return mealPlanRep.findOne(id);
	}

}
