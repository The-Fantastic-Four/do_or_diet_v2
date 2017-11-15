package is.hi.hbv.do_or_diet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import is.hi.hbv.do_or_diet.model.IngredientQuantity;
import is.hi.hbv.do_or_diet.repository.IngredientQuantityRepository;

/**
 * @author Eiður Örn Gunnarsson eog26@hi.is
 * @date 16. okt. 2017
 */
@Service
public class IngredientQuantityServiceImp implements IngredientQuantityService
{
	@Autowired
	IngredientQuantityRepository ingredientQuantityRep;

	@Override
	public void addIngredientQuantity(IngredientQuantity ingrQuantity)
	{
		ingredientQuantityRep.save(ingrQuantity);
	}

	@Override
	public void deleteIngredientQuantity(long id)
	{
		ingredientQuantityRep.deleteByrecipe_id(id);
	}
	@Override
	public List<IngredientQuantity> allIngredientQuantities()
	{
		return ingredientQuantityRep.findAll();
	}

	@Override
	public IngredientQuantity findIngredientQuantity(long id)
	{
		return ingredientQuantityRep.findOne(id);
	}

}
