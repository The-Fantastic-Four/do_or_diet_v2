/**
 * User describes a user in the system
 * @author Eiður Örn Gunnarsson eog26@hi.is
 */
package is.hi.hbv.do_or_diet.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="\"user\"")
public class User {
	
	/**
	 * Unique identifier for this user
	 */
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	private long id;
	
	/**
	 * Username of this user
	 */
	private String userName;
	
	/**
	 * List of this users' favourite recipes
	 */
	//private List<Recipe> favoriteRecipies;

	public User()
	{
		
	}
	
	/**
	 * Create a new user
	 * @param id unique identifier for this user
	 * @param userName the username of this user
	 */
	public User(long id, String userName) {
		this.id = id;
		this.userName = userName;
	}

	/**
	 * Create a new user
	 * @param id unique identifier for this user
	 * @param userName the username of this user
	 * @param favoriteRecipies list of the users favourite recipes
	 */
	/*public User(long id, String userName, List<Recipe> favoriteRecipies) {
		this.id = id;
		this.userName = userName;
		this.favoriteRecipies = favoriteRecipies;
	}*/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/*public List<Recipe> getFavoriteRecipies() {
		return favoriteRecipies;
	}

	public void setFavoriteRecipies(List<Recipe> favoriteRecipies) {
		this.favoriteRecipies = favoriteRecipies;
	}*/

}
