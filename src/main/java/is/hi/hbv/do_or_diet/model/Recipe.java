/**
 * Recipe describes a recipe
 * @author Eiður Örn Gunnarsson eog26@hi.is
 */
package is.hi.hbv.do_or_diet.model;

import java.util.ArrayList;

public class Recipe {
	
	/**
	 * Unique identifier for the recipe
	 */
	private long id;
	
	/**
	 * The name of the recipe
	 */
	private String name;
	
	/**
	 * The categories this recipe belongs to
	 */
	private ArrayList<String> categories;
	
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
	private ArrayList<Ingredient> ingredients;
	
	/**
	 * Creates a new recipe
	 * @param id unique identifier for this recipe
	 * @param name the name of this recipe
	 * @param categories the categories this recipe belongs to
	 * @param directions the instructions for this recipe
	 * @param servings how many servings this recipe makes
	 * @param ingredients list of ingredients needed to cook this recipe
	 */
	public Recipe(long id, String name, ArrayList<String> categories, String directions, int servings,
			ArrayList<Ingredient> ingredients) {
		this.id = id;
		this.name = name;
		this.categories = categories;
		this.directions = directions;
		this.servings = servings;
		this.ingredients = ingredients;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getCategories() {
		return categories;
	}

	public void setCategories(ArrayList<String> categories) {
		this.categories = categories;
	}

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public int getServings() {
		return servings;
	}

	public void setServings(int servings) {
		this.servings = servings;
	}

	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
}
