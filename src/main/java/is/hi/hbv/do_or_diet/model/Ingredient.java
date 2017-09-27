package is.hi.hbv.do_or_diet.model;

public class Ingredient {
	private long id;
	private String name;
	private int quantity;
	private String measurement;

	public Ingredient(long id, String name, int quantity, String measurement) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.measurement = measurement;
	}
	
	public Ingredient() {
		
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            is the variable to set name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            is the variable to set quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

}
