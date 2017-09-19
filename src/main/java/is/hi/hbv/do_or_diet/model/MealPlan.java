package is.hi.hbv.do_or_diet.model;

import java.util.Date;
import java.util.ArrayList;

public class MealPlan {
	private long id;
	private String name;
	private ArrayList<MealPlanItem> items;
	private ArrayList<Date> dates;
	private User createdBy;

	public MealPlan(long id, String name, ArrayList<MealPlanItem> items, ArrayList<Date> dates) {
		this.id = id;
		this.name = name;
		this.items = items;
		this.dates = dates;
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
	 * @return the items
	 */
	public ArrayList<MealPlanItem> getItems() {
		return items;
	}

	/**
	 * @param items
	 *            is the variable to set items
	 */
	public void setItems(ArrayList<MealPlanItem> items) {
		this.items = items;
	}

	/**
	 * @return the dates
	 */
	public ArrayList<Date> getDates() {
		return dates;
	}

	/**
	 * @param dates
	 *            is the variable to set dates
	 */
	public void setDates(ArrayList<Date> dates) {
		this.dates = dates;
	}

	/**
	 * @return the createdBy
	 */
	public User getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy is the variable to set createdBy
	 */
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
