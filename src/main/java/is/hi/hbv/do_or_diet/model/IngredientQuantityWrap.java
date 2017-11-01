/**
 * IngredientQuantityWrap keeps wraps variables as one object from UI
 * 
 * @author Fannar Þeyr Guðmundsson fthg2@hi.is
 * @date október 2017
 */
package is.hi.hbv.do_or_diet.model;

public class IngredientQuantityWrap
{

	private int quantity;
	private String measurement;
	private String recipeName;
	private String ingredientName;
	private String categories;
	private String directions;
	private int servings;
	

	
	public IngredientQuantityWrap()
	{
		
	}
	
	public IngredientQuantityWrap(String recipeName, String ingredientName, String measurement, int quantity, String categories, String directions, int servings)
	{
		this.recipeName = recipeName;
		this.quantity = quantity;
		this.measurement = measurement;
		this.ingredientName = ingredientName;
		this.categories = categories;
		this.directions = directions;
		this.servings = servings;
	}

	public String getMeasurement()
	{
		return measurement;
	}

	public void setMeasurement(String measurement)
	{
		this.measurement = measurement;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
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
}
