/**
 * Role describes the roles of user accounts
 * @author Ragnheiður Ásta Karlsdóttir rak4@hi.is
 * @author Viktor Alex Brynjarsson vab18@hi.is
 */
package is.hi.hbv.do_or_diet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role 
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	
	private String role;
	
	public Role()
	{
		
	}

	/**
	 * @return the id
	 */
	public int getId() 
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) 
	{
		this.id = id;
	}

	/**
	 * @return the role
	 */
	public String getRole() 
	{
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) 
	{
		this.role = role;
	}
}
