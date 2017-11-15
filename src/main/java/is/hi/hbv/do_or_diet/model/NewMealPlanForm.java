/**
 * A model that takes in all fields from a specific form in the GUI fields
 * 
 * @author Eiður Örn Gunnarsson eog26@hi.is
 * @date 10. nov. 2017
 */
package is.hi.hbv.do_or_diet.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class NewMealPlanForm
{
	// Pattern to validate date format input (including leap years), created by Asiq
	// Ahamed, minorly modified to not accept YY and have minimum year 2000.
	private static final String PATTERN = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|"
			+ "(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|"
			+ "[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|"
			+ "[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|"
			+ "[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|"
			+ "(?:1[0-2]))\\4(?:(?:2[6-9]|[2-9]\\d)\\d{2})$";

	@NotNull(message = "Þessi reitur má ekki vera tómur.")
	@Size(min = 1, max = 35, message = "Lengd nafns þarf að vera á bilinu 1-35")
	private String name;

	@NotNull(message = "Þessi reitur má ekki vera tómur.")
	@Pattern(regexp = PATTERN, message = "Vinsamlegast hafðu dagsetningu á forminu MM/DD/YYYY, "
			+ "MM.DD.YYYY eða MM-DD-YYYY")
	private String fromDate;

	@NotNull(message = "Þessi reitur má ekki vera tómur.")
	@Pattern(regexp = PATTERN, message = "Vinsamlegast hafðu dagsetningu á forminu MM/DD/YYYY, "
			+ "MM.DD.YYYY eða MM-DD-YYYY")
	private String toDate;

	public NewMealPlanForm(String name, String fromDate, String toDate)
	{
		this.name = name;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public NewMealPlanForm()
	{

	}

	public String getName()
	{
		return name;
	}

	public String getFromDate()
	{
		return fromDate;
	}

	public String getToDate()
	{
		return toDate;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setFromDate(String fromDate)
	{
		this.fromDate = fromDate;
	}

	public void setToDate(String toDate)
	{
		this.toDate = toDate;
	}
}
