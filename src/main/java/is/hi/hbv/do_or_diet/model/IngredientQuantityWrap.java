/**
 * IngredientQuantityWrap keeps wraps variables as one object from UI
 * 
 * @author Fannar Þeyr Guðmundsson fthg2@hi.is
 * @date October 2017
 */
package is.hi.hbv.do_or_diet.model;

public class IngredientQuantityWrap
{
	/**
	 * Maps to the quantity field in IngredientQuantity
	 */
	private String quantity;
	
	/**
	 * Maps to the measurement field in IngredientQuantity
	 */
	private String measurement;
	
	/**
	 * Maps to the name field in Recipe
	 */
	private String recipeName;
	
	/**
	 * Maps to the name field in IngredientType
	 */
	private String ingredientName;
	
	/**
	 * Maps to the categories field in Recipe
	 */
	private String categories;
	
	/**
	 * Maps the the directions field in Recipe
	 */
	private String directions;
	
	/**
	 * Maps to the servings field in Recipe
	 */
	private int servings;
	
	/**
	 * Maps to the id field in Recipe
	 */
	private int recipeId;

	public IngredientQuantityWrap()
	{

	}

	/**
	 * Creates a new ingredient quantity wrap
	 * @param recipeName name of the recipe
	 * @param ingredientName name of the ingredient type
	 * @param measurement measurement of ingredient
	 * @param quantity quantity of ingredient
	 * @param categories categories for the recipes
	 * @param directions recipe directions
	 * @param servings the number of services in this recipe
	 * @param recipeId the identifier for this recipe
	 */
	public IngredientQuantityWrap(String recipeName, String ingredientName, String measurement, String quantity,
			String categories, String directions, int servings, int recipeId)
	{
		this.recipeName = recipeName;
		this.quantity = quantity;
		this.measurement = measurement;
		this.ingredientName = ingredientName;
		this.categories = categories;
		this.directions = directions;
		this.servings = servings;
		this.recipeId = recipeId;
	}


	public String getMeasurement()
	{
		return measurement;
	}

	public void setMeasurement(String measurement)
	{
		this.measurement = measurement;
	}

	public String getQuantity()
	{
		return quantity;
	}

	public void setQuantity(String quantity)
	{
		this.quantity = quantity;
	}

	public String getRecipeName()
	{
		return recipeName;
	}

	public void setRecipeName(String recipeName)
	{
		this.recipeName = recipeName;
	}

	public String getIngredientName()
	{
		return ingredientName;
	}

	public void setIngredientName(String ingredientName)
	{
		this.ingredientName = ingredientName;
	}

	public String getDirections()
	{
		return directions;
	}

	public void setDirections(String directions)
	{
		this.directions = directions;
	}

	public String getCategories()
	{
		return categories;
	}

	public void setCategories(String categories)
	{
		this.categories = categories;
	}

	public int getServings()
	{
		return servings;
	}

	public void setServings(int servings)
	{
		this.servings = servings;
	}
	
	public int getRecipeId()
	{
		return recipeId;
	}
	
	public void setRecipeId(int recipeId)
	{
		this.recipeId = recipeId;
	}
	
}
