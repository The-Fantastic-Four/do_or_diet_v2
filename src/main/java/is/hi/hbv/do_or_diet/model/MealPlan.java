/**
 * Describes a meal plan
 * 
 * @author Eiður Örn Gunnarsson eog26@hi.is
 * @date október 2017
 */
package is.hi.hbv.do_or_diet.model;

import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "meal_plan")
public class MealPlan
{

	/**
	 * Unique identifier for the meal plan
	 */
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;

	/**
	 * Name of the meal plan
	 */
	@NotNull(message = "Þessi reitur má ekki vera tómur.")
	@Size(min = 1, max = 35, message = "Lengd nafns þarf að vera á bilinu 1-35")
	private String name;

	/**
	 * List of meals on this plan
	 */
	@OneToMany(mappedBy = "mealPlan")
	private List<MealPlanItem> items;

	/**
	 * The dates included in this meal plan
	 */
	@ElementCollection
	private List<Date> dates;

	/**
	 * The user that created this meal plan
	 */
	@ManyToOne
	@JoinColumn(name = "created_by_user_id")
	private User createdBy;

	public MealPlan()
	{

	}

	/**
	 * Creates a new meal plan
	 * 
	 * @param name
	 *            name of the meal plan
	 * @param items
	 *            list of items on the meal plan
	 * @param dates
	 *            list of dates on which the meal plan
	 */
	public MealPlan(String name, List<MealPlanItem> items, List<Date> dates, User createdBy)
	{
		this.name = name;
		this.items = items;
		this.dates = dates;
		this.createdBy = createdBy;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public List<MealPlanItem> getItems()
	{
		return items;
	}

	public void setItems(List<MealPlanItem> items)
	{
		this.items = items;
	}

	public List<Date> getDates()
	{
		return dates;
	}

	public void setDates(List<Date> dates)
	{
		this.dates = dates;
	}

	public User getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy(User createdBy)
	{
		this.createdBy = createdBy;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Date getDateFrom()
	{
		return this.dates.get(0);
	}

	public Date getDateTo()
	{
		return this.dates.get(this.dates.size() - 1);
	}
}
