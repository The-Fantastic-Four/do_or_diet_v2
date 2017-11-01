/**
 * IngredientType describes an ingredient
 * 
 * @author Eiður Örn Gunnarsson eog26@hi.is
 * @author Viktor Alex Brynjarsson vab18@hi.is
 * @date október 2017
 */
package is.hi.hbv.do_or_diet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ingredient_type")
public class IngredientType
{
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;

	private String name;

	public IngredientType()
	{

	}

	public IngredientType(long id, String name)
	{
		this.id = id;
		this.name = name;
	}

	public String toString()
	{
		return "[IngredientType name=" + this.name + "]";
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

}
