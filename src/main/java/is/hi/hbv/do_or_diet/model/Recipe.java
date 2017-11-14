/**
 * Recipe describes a recipe
 * 
 * @author Eiður Örn Gunnarsson eog26@hi.is
 * @date október 2017
 */
package is.hi.hbv.do_or_diet.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "recipe")
public class Recipe
{

	/**
	 * Unique identifier for the recipe
	 */
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;

	/**
	 * The name of the recipe
	 */
	private String name;

	/**
	 * The categories this recipe belongs to
	 */
	@ElementCollection
	private List<String> categories;

	/**
	 * Cooking instructions for this recipe
	 */
	private String directions;

	/**
	 * How many servings this recipe makes
	 */
	private int servings;

	/**
	 * List of ingredients needed to cook this recipe
	 */
	@OneToMany(mappedBy = "recipe")
	private List<IngredientQuantity> ingredients;

	/**
	 * Says if recipe is private or not
	 */
	private boolean isPrivate;
	
	/*
	 * Identifies who made the recipe
	 */
	@ManyToOne
	@JoinColumn(name = "created_by_user_id")
	private User createdBy;

	public Recipe()
	{

	}

	/**
	 * Creates a new recipe
	 * 
	 * @param id
	 *            unique identifier for this recipe
	 * @param name
	 *            the name of this recipe
	 * @param categories
	 *            the categories this recipe belongs to
	 * @param directions
	 *            the instructions for this recipe
	 * @param servings
	 *            how many servings this recipe makes
	 * @param ingredients
	 *            list of ingredients needed to cook this recipe
	 */
	public Recipe(long id, String name, List<String> categories, String directions, int servings,
			List<IngredientQuantity> ingredients, boolean is_private)
	{
		this.id = id;
		this.name = name;
		this.categories = categories;
		this.directions = directions;
		this.servings = servings;
		this.ingredients = ingredients;
	}
	
	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<String> getCategories()
	{
		return categories;
	}

	public void setCategories(List<String> categories)
	{
		this.categories = categories;
	}

	public String getDirections()
	{
		return directions;
	}

	public void setDirections(String directions)
	{
		this.directions = directions;
	}

	public int getServings()
	{
		return servings;
	}

	public void setServings(int servings)
	{
		this.servings = servings;
	}

	public List<IngredientQuantity> getIngredients()
	{
		return ingredients;
	}

	public void setIngredients(List<IngredientQuantity> ingredients)
	{
		this.ingredients = ingredients;
	}

	public boolean isPrivate()
	{
		return isPrivate;
	}

	public void setPrivate(boolean isPrivate)
	{
		this.isPrivate = isPrivate;
	}

	public User getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy(User createdBy)
	{
		this.createdBy = createdBy;
	}
}
