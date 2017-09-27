package is.hi.hbv.do_or_diet.model;

public class IngredientType {
	
	private static long id;
	
	private String name;
	
	static {id=0;}

	
	public IngredientType(String name) {
		id++;
		this.name = name;
	}

	public static long getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
