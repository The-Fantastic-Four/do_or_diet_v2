/**
 * Describes a shopping list created from a meal plan
 * 
 * @author Eiður Örn Gunnarsson eog26@hi.is
 * @author Viktor Alex Brynjarsson vab18@hi.is
 * @date October 2017
 */
package is.hi.hbv.do_or_diet.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "shopping_list")
public class ShoppingList
{

	/**
	 * Unique identifier for this shopping list
	 */
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;

	/**
	 * List of items on this shopping list
	 */
	@OneToMany(mappedBy = "shoppingList")
	@OrderBy("itemName ASC")
	private List<ShoppingListItem> items;

	/**
	 * The meal plan this shopping list was created from
	 */
	@ManyToOne
	@JoinColumn(name = "meal_plan_id")
	private MealPlan mealPlan;

	/**
	 * The owner of this shopping list
	 */
	@ManyToOne
	@JoinColumn(name = "user_owner_id")
	private User owner;

	public ShoppingList()
	{

	}

	/**
	 * Create a new shopping list
	 * 
	 * @param id
	 *            unique identifier for this shopping list
	 * @param items
	 *            the items on this shopping list
	 * @param mealPlan
	 *            the meal plan this shopping list was created from
	 */
	public ShoppingList(long id, List<ShoppingListItem> items, MealPlan mealPlan)
	{
		this.id = id;
		this.items = items;
		this.mealPlan = mealPlan;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public List<ShoppingListItem> getItems()
	{
		return items;
	}

	public void setItems(List<ShoppingListItem> items)
	{
		this.items = items;
	}

	public MealPlan getMealPlan()
	{
		return mealPlan;
	}

	public void setMealPlan(MealPlan mealPlan)
	{
		this.mealPlan = mealPlan;
	}

	public User getOwner()
	{
		return owner;
	}

	public void setOwner(User owner)
	{
		this.owner = owner;
	}
}
