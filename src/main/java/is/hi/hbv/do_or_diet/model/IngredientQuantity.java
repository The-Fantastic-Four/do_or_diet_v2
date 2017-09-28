package is.hi.hbv.do_or_diet.model;

public class IngredientQuantity {
	private long id;
	private int quantity; 
	private String measurement;
	private IngredientType ingredient;

	public IngredientQuantity(long id, int quantity, String measurement, IngredientType ingredient) {
		this.id = id;
		this.quantity = quantity;
		this.measurement = measurement;
		this.ingredient = ingredient;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getMeasurement() {
		return measurement;
	}

	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}

	public IngredientType getIngredient() {
		return ingredient;
	}

	public void setIngredient(IngredientType ingredient) {
		this.ingredient = ingredient;
	}
	
	
}
