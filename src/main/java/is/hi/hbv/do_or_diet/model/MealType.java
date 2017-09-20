/**
 * MealType the different types of meals (breakfast, lunch and dinner)
 * @author Viktor Alex Brynjarsson vab18@hi.is
 */
package is.hi.hbv.do_or_diet.model;

public enum MealType {
	BREAKFAST("Morgunmatur", "breakfast"), 
	LUNCH("Hádegismatur", "lunch"), 
	DINNER("Kvöldmatur", "dinner");
	
	/**
	 * The name that will be displayed to the user
	 */
	private final String displayName;
	
	/**
	 * The name that will be used in the datasets and in code
	 */
	private final String shortName;
	
	/**
	 * Create a new meal type
	 * @param displayName the name that will be displayed to the user
	 * @param shortName the name that will be used in the datasets and in code
	 */
	private MealType(String displayName, String shortName)
	{
		this.displayName = displayName;
		this.shortName = shortName;
	}
	
	public String getDisplayName()
	{
		return this.displayName;
	}
	
	public String getShortName()
	{
		return this.shortName;
	}
}
