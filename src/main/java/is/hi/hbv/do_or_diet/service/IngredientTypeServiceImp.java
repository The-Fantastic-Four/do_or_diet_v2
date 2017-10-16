package is.hi.hbv.do_or_diet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import is.hi.hbv.do_or_diet.model.IngredientType;
import is.hi.hbv.do_or_diet.repository.IngredientTypeRepository;

/**
 * @author Eiður Örn Gunnarsson eog26@hi.is
 * @date 16. okt. 2017
 */
@Service
public class IngredientTypeServiceImp implements IngredientTypeService
{
	@Autowired
	IngredientTypeRepository ingredientTypeRep;

	@Override
	public void addIngredientType(IngredientType ingrType)
	{
		ingredientTypeRep.save(ingrType);
	}

	@Override
	public List<IngredientType> allIngredientTypes()
	{
		return ingredientTypeRep.findAll();
	}

	@Override
	public IngredientType findIngredientType(long id)
	{
		return ingredientTypeRep.findOne(id);
	}

}
