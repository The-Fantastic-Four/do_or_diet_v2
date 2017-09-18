package is.hi.hbv.do_or_diet.model;

import java.util.ArrayList;

public class User {
	private long id;
	private String userName;
	private ArrayList<Recipe> favoriteRecipies;

	public User(long id, String userName) {
		this.id = id;
		this.userName = userName;
	}

	public User(long id, String userName, ArrayList<Recipe> favoriteRecipies) {
		this.id = id;
		this.userName = userName;
		this.favoriteRecipies = favoriteRecipies;
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            is the variable to set userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the favoriteRecipies
	 */
	public ArrayList<Recipe> getFavoriteRecipies() {
		return favoriteRecipies;
	}

	/**
	 * @param favoriteRecipies
	 *            is the variable to set favoriteRecipies
	 */
	public void setFavoriteRecipies(ArrayList<Recipe> favoriteRecipies) {
		this.favoriteRecipies = favoriteRecipies;
	}

}
