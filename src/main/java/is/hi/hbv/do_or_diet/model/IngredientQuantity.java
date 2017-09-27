package is.hi.hbv.do_or_diet.model;

public class IngredientQuantity {

	private static long id;
	
	private int quantity; 
	
	private String measurement;
	
	private IngredientType ingredient;
	
	static {id =0;}

	public IngredientQuantity(int quantity, String measurement, IngredientType ingredient) {
		id++;
		this.quantity = quantity;
		this.measurement = measurement;
		this.ingredient = ingredient;
	}


	public static long getId() {
		return id;
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
