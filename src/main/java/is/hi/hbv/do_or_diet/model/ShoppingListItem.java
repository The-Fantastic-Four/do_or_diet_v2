/**
 * ShoppingListItem describes a specific item on shopping list
 * @author Eiður Örn Gunnarsson eog26@hi.is
 */
package is.hi.hbv.do_or_diet.model;

public class ShoppingListItem {
	
	/**
	 * Unique identifier for this item on the shopping list
	 */
	private long id;
	
	/**
	 * The name of the item on the shopping list
	 */
	private String itemName;
	
	/**
	 * The amount needed of this shopping list item (used in conjuction with measurement)
	 */
	private int amount;
	
	/**
	 * The measurement used for this shopping list item (used in conjuction with amount)
	 */
	private String measurement;
	
	/**
	 * Whether this item has been checked
	 */
	private boolean checked;

	/**
	 * Create a new shopping list item
	 * @param id unique identifier for this item on the shopping list
	 * @param itemName the name of the item
	 * @param amount the amount needed
	 * @param measurement the measurement used
	 * @param checked whether this item is checked or not
	 */
	public ShoppingListItem(long id, String itemName, int amount, String measurement, boolean checked) {
		this.id = id;
		this.itemName = itemName;
		this.amount = amount;
		this.measurement = measurement;
		this.checked = checked;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getMeasurement() {
		return measurement;
	}

	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
