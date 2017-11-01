/**
 * ShoppingListItem describes a specific item on shopping list
 * 
 * @author Eiður Örn Gunnarsson eog26@hi.is
 * @author Viktor Alex Brynjarsson vab18@hi.is
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
@Table(name = "shopping_list_item")
public class ShoppingListItem
{

	/**
	 * Unique identifier for this item on the shopping list
	 */
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;

	/**
	 * The name of the item on the shopping list
	 */
	private String itemName;

	/**
	 * The amount needed of this shopping list item (used in conjuction with
	 * measurement)
	 */
	private int amount;

	/**
	 * The measurement used for this shopping list item (used in conjuction with
	 * amount)
	 */
	private String measurement;

	/**
	 * Whether this item has been checked
	 */
	private boolean checked;

	/**
	 * The shopping list that this item is on
	 */
	@ManyToOne
	@JoinColumn(name = "shopping_list_id")
	private ShoppingList shoppingList;
	
	public ShoppingListItem()
	{
		
	}

	/**
	 * Create a new shopping list item
	 * 
	 * @param id
	 *            unique identifier for this item on the shopping list
	 * @param itemName
	 *            the name of the item
	 * @param amount
	 *            the amount needed
	 * @param measurement
	 *            the measurement used
	 * @param checked
	 *            whether this item is checked or not
	 */
	public ShoppingListItem(long id, String itemName, int amount, String measurement, boolean checked)
	{
		this.id = id;
		this.itemName = itemName;
		this.amount = amount;
		this.measurement = measurement;
		this.checked = checked;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getItemName()
	{
		return itemName;
	}

	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}

	public int getAmount()
	{
		return amount;
	}

	public void setAmount(int amount)
	{
		this.amount = amount;
	}

	public String getMeasurement()
	{
		return measurement;
	}

	public void setMeasurement(String measurement)
	{
		this.measurement = measurement;
	}

	public boolean isChecked()
	{
		return checked;
	}

	public void setChecked(boolean checked)
	{
		this.checked = checked;
	}
	
	public void setShoppingList(ShoppingList shoppingList)
	{
		this.shoppingList = shoppingList;
	}
}
