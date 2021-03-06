/**
 * IngredientQuantity connects recipes and ingredients
 * 
 * @author Eiður Örn Gunnarsson eog26@hi.is
 * @author Viktor Alex Brynjarsson vab18@hi.is
 * @date October 2017
 */
package is.hi.hbv.do_or_diet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ingredient_quantity")
public class IngredientQuantity
{
	/**
	 * Id of the Ingredient Quantity
	 */
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;
	/**
	 * The amount referenced ingredient
	 */
	private double quantity;
	/**
	 * What type of measurement is used for the ingredient
	 */
	private String measurement;

	/**
	 * Type of ingredient
	 */
	@ManyToOne
	@JoinColumn(name = "ingredient_type_id")
	private IngredientType ingredient;

	/**
	 * Recipe that ingredient quantity is for
	 */
	@ManyToOne
	@JoinColumn(name = "recipe_id")
	private Recipe recipe;

	/**
	 * Empty constructor
	 */
	public IngredientQuantity()
	{

	}

	/**
	 * IngredientQuantity constructor with fields
	 * 
	 * @param id
	 *            of ingredient quantity
	 * @param quantity
	 *            the amount of ingredient type
	 * @param measurement
	 *            the measurement for the ingredient
	 * @param ingredient
	 * @param recipe
	 */
	public IngredientQuantity(long id, double quantity, String measurement, IngredientType ingredient, Recipe recipe)
	{
		this.id = id;
		this.quantity = quantity;
		this.measurement = measurement;
		this.ingredient = ingredient;
		this.recipe = recipe;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public double getQuantity()
	{
		return quantity;
	}

	public void setQuantity(double quantity)
	{
		this.quantity = quantity;
	}

	public String getMeasurement()
	{
		return measurement;
	}

	public void setMeasurement(String measurement)
	{
		this.measurement = measurement;
	}

	public IngredientType getIngredient()
	{
		return ingredient;
	}

	public void setIngredient(IngredientType ingredient)
	{
		this.ingredient = ingredient;
	}

	public Recipe getRecipe()
	{
		return recipe;
	}

	public void setRecipe(Recipe recipe)
	{
		this.recipe = recipe;
	}

}
