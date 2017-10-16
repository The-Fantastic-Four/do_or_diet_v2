package is.hi.hbv.do_or_diet.service;

import java.util.List;

import is.hi.hbv.do_or_diet.model.IngredientType;

/**
 * Service that connects to the ingredient type repository
 * 
 * @author Eiður Örn Gunnarsson eog26@hi.is
 * @date 16. okt. 2017
 */
public interface IngredientTypeService
{
	/**
	 * Adds an ingredient type to the ingredient type repository
	 * 
	 * @param ingrType
	 *            ingredient type to be added
	 */
	public void addIngredientType(IngredientType ingrType);

	/**
	 * Fetches all of the ingredient types from repository
	 * 
	 * @return list of all ingredient types
	 */
	public List<IngredientType> allIngredientTypes();

	/**
	 * Finds an ingredient type from ingredient type ID
	 * 
	 * @param id
	 *            of ingredient type
	 * @return ingredient type with appropriate ID
	 */
	public IngredientType findIngredientType(long id);
}
