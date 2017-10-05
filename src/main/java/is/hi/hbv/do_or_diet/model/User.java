/**
 * User describes a user in the system
 * 
 * @author Eiður Örn Gunnarsson eog26@hi.is
 * @author Ragnheiður Ásta Karlsdóttir rak4@hi.is
 * @author Viktor Alex Brynjarsson vab18@hi.is
 */
package is.hi.hbv.do_or_diet.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "\"user\"")
public class User
{

	/**
	 * Unique identifier for this user
	 */
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;

	/**
	 * Username of this user
	 */
	private String username;

	/**
	 * List of this users' favourite recipes
	 */
	// private List<Recipe> favoriteRecipies;

	@Transient
	private String password;

	@Email
	private String email;

	private int active;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	public User()
	{

	}

	/**
	 * Create a new user
	 * 
	 * @param id
	 *            unique identifier for this user
	 * @param userName
	 *            the username of this user
	 */
	public User(String username, String password, String email)
	{
		this.username = username;
		this.password = password;
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

	/**
	 * @return the active
	 */
	public int getActive()
	{
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(int active)
	{
		this.active = active;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	/**
	 * @return the roles
	 */
	public Set<Role> getRoles()
	{
		return roles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(Set<Role> roles)
	{
		this.roles = roles;
	}

	// To be applied later on in the process:
	/*
	 * public List<Recipe> getFavoriteRecipies() { return favoriteRecipies; }
	 * 
	 * public void setFavoriteRecipies(List<Recipe> favoriteRecipies) {
	 * this.favoriteRecipies = favoriteRecipies; }
	 */
}
