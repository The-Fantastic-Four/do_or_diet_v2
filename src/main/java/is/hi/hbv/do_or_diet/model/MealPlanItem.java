/**
 * MealPlanItem describes the recipe, date, and type of meal for an item on a meal plan
 * @author Eiður Örn Gunnarsson eog26@hi.is
 */
package is.hi.hbv.do_or_diet.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="meal_plan_item")
public class MealPlanItem 
{
	
	/**
	 * Unique identifier for the meal plan item
	 */
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	private long id;
	
	/**
	 * The recipe chosen for this meal plan item
	 */
	@ManyToOne
	@JoinColumn(name="recipe_id")
	private Recipe recipe;
	
	/**
	 * The date on which this meal is planned
	 */
	private Date date;
	
	/**
	 * The type of meal (breakfast, lunch, or dinner)
	 */
	@Enumerated(EnumType.STRING)
	private MealType mealType;
	
	public MealPlanItem()
	{
		
	}
	
	/**
	 * Creates a new meal plan item
	 * @param recipe the recipe for this meal
	 * @param date the date which this meal is planned
	 * @param mealType the type of meal (breakfast, lunch, or dinner)
	 */
	public MealPlanItem(Recipe recipe, Date date, MealType mealType) 
	{
		this.recipe = recipe;
		this.date = date;
		this.mealType = mealType;
	}

	public long getId() 
	{
		return id;
	}

	public Recipe getRecipe() 
	{
		return recipe;
	}

	public void setRecipe(Recipe recipe) 
	{
		this.recipe = recipe;
	}

	public Date getDate() 
	{
		return date;
	}

	public void setDate(Date date) 
	{
		this.date = date;
	}

	public MealType getMealType() 
	{
		return mealType;
	}

	public void setMealType(MealType mealType) 
	{
		this.mealType = mealType;
	}
}
