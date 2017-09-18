package is.hi.hbv.do_or_diet.model;

import java.util.ArrayList;

public class Recipe {
	private long id;
	private String name;
	private ArrayList<String> categories;
	private String directions;
	private int servings;
	private ArrayList<Ingredient> ingredients;

	
	
	public Recipe(long id, String name, ArrayList<String> categories, String directions, int servings,
			ArrayList<Ingredient> ingredients) {
		this.id = id;
		this.name = name;
		this.categories = categories;
		this.directions = directions;
		this.servings = servings;
		this.ingredients = ingredients;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            is the variable to set id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            is the variable to set name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the categories
	 */
	public ArrayList<String> getCategories() {
		return categories;
	}

	/**
	 * @param categories
	 *            is the variable to set categories
	 */
	public void setCategories(ArrayList<String> categories) {
		this.categories = categories;
	}

	/**
	 * @return the directions
	 */
	public String getDirections() {
		return directions;
	}

	/**
	 * @param directions
	 *            is the variable to set directions
	 */
	public void setDirections(String directions) {
		this.directions = directions;
	}

	/**
	 * @return the servings
	 */
	public int getServings() {
		return servings;
	}

	/**
	 * @param servings
	 *            is the variable to set servings
	 */
	public void setServings(int servings) {
		this.servings = servings;
	}

	/**
	 * @return the ingredients
	 */
	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}

	/**
	 * @param ingredients
	 *            is the variable to set ingredients
	 */
	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
}
