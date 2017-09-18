package is.hi.hbv.do_or_diet.model;

public class ShoppingListItem {
	private long id;
	private String itemName;
	private int amount;
	private String measurement;
	private boolean checked;

	public ShoppingListItem(long id, String itemName, int amount, String measurement, boolean checked) {
		this.id = id;
		this.itemName = itemName;
		this.amount = amount;
		this.measurement = measurement;
		this.checked = checked;
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
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName
	 *            is the variable to set itemName
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            is the variable to set amount
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the measurement
	 */
	public String getMeasurement() {
		return measurement;
	}

	/**
	 * @param measurement
	 *            is the variable to set measurement
	 */
	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}

	/**
	 * @return the checked
	 */
	public boolean isChecked() {
		return checked;
	}

	/**
	 * @param checked
	 *            is the variable to set checked
	 */
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
