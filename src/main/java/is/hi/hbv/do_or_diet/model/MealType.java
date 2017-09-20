package is.hi.hbv.do_or_diet.model;

public enum MealType {
	BREAKFAST("Morgunmatur", "breakfast"), 
	LUNCH("Hádegismatur", "lunch"), 
	DINNER("Kvöldmatur", "dinner");
	
	private final String displayName;
	private final String shortName;
	
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
