/**
 * Describes a meal plan
 * @author Eiður Örn Gunnarsson eog26@hi.is
 */
package is.hi.hbv.do_or_diet.model;

import java.util.Date;
import java.util.ArrayList;

public class MealPlan {
	
	/**
	 * Unique identifier for the meal plan
	 */
	private long id;
	
	/**
	 * Name of the meal plan
	 */
	private String name;
	
	/**
	 * List of meals on this plan
	 */
	private ArrayList<MealPlanItem> items;
	
	/**
	 * The dates included in this meal plan
	 */
	private ArrayList<Date> dates;
	
	/**
	 * The user that created this meal plan
	 */
	private User createdBy;

	/**
	 * Creates a new meal plan
	 * @param id unique identifier for the meal plan
	 * @param name name of the meal plan
	 * @param items list of items on the meal plan
	 * @param dates list of dates on which the meal plan
	 */
	public MealPlan(long id, String name, ArrayList<MealPlanItem> items, ArrayList<Date> dates) {
		this.id = id;
		this.name = name;
		this.items = items;
		this.dates = dates;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ArrayList<MealPlanItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<MealPlanItem> items) {
		this.items = items;
	}

	public ArrayList<Date> getDates() {
		return dates;
	}

	public void setDates(ArrayList<Date> dates) {
		this.dates = dates;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
