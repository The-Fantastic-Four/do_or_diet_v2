/**
 * MealPlanController enables the user to interact with meal plans
 * 
 * @author Eiður Örn Gunnarsson eog26@hi.is
 * @author Viktor Alex Brynjarsson vab18@hi.is
 * @date 13. nov. 2017
 */
package is.hi.hbv.do_or_diet.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import is.hi.hbv.do_or_diet.model.MealPlan;
import is.hi.hbv.do_or_diet.model.MealPlanItem;
import is.hi.hbv.do_or_diet.model.MealPlanItemWrapper;
import is.hi.hbv.do_or_diet.model.NewMealPlanForm;
import is.hi.hbv.do_or_diet.model.Recipe;
import is.hi.hbv.do_or_diet.model.User;
import is.hi.hbv.do_or_diet.repository.MealPlanRepository;
import is.hi.hbv.do_or_diet.service.MealPlanItemService;
import is.hi.hbv.do_or_diet.service.MealPlanService;
import is.hi.hbv.do_or_diet.service.RecipeService;
import is.hi.hbv.do_or_diet.service.UserService;

@Controller
@RequestMapping("/mealplan")
public class MealPlanController
{

	// Instance of the meal plan repository, used to get and create meal plans
	@Autowired
	MealPlanService mealPlanService;

	// Instance of the recipe repository, used to get and create recipes
	@Autowired
	RecipeService recipeService;

	@Autowired
	MealPlanItemService mealPlanItemService;

	// Instance of the user repository used to get the current user
	@Autowired
	UserService userService;

	/**
	 * Index page for the meal plans, shows a list of meal plans
	 * 
	 * @param model
	 *            the model that contains all the necessary information
	 * @return site that displays related meal plans
	 */
	@RequestMapping("")
	public String indexPage(Model model, Authentication authentication)
	{
		User user = userService.findUserByEmail(authentication.getName());
		addMealPlanListToModel(model, user);
		model.addAttribute("mealPlanForm", new NewMealPlanForm());
		return "mealplan/index";
	}

	/**
	 * Creates a new meal plan, redirects to the index page upon creation
	 * 
	 * @param mealPlan
	 *            object containing the name of the meal plan
	 * @param errors
	 *            obtained from validation
	 * @param fromDate
	 *            is the date which the meal plan begins on
	 * @param toDate
	 *            is the date which the meal plan ends on
	 * @param model
	 *            the model that contains all the necessary information
	 * @param authentication
	 * @return site that displays meal plans including the new one if successfully
	 *         created
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String newMealPlan(@Valid @ModelAttribute("mealPlanForm") NewMealPlanForm mealPlan, BindingResult errors,
			Model model, Authentication authentication)
	{
		User user = userService.findUserByEmail(authentication.getName());
		if (!errors.hasErrors())
		{
			ArrayList<Date> dates = new ArrayList<Date>();
			try
			{
				dates = generateDatesBetween(convertToDate(mealPlan.getFromDate()),
						convertToDate(mealPlan.getToDate()));
			}
			catch (ParseException e)
			{
				e.printStackTrace();
			}

			MealPlan m = new MealPlan(mealPlan.getName(), new ArrayList<MealPlanItem>(), dates, user);
			mealPlanService.addMealPlan(m);
		}

		addMealPlanListToModel(model, user);

		return "mealplan/index";
	}

	/**
	 * Shows a specific meal plan, allows the user to edit it
	 * 
	 * @param mealPlanId
	 *            unique identifier for the meal plan that is being viewed
	 * @param model
	 *            the model that contains all the necessary information
	 * @return more detailed information for the specified meal plan
	 */
	@RequestMapping("/{mealPlanId}")
	public String showMealPlan(@PathVariable(value = "mealPlanId") long mealPlanId, ModelMap model,
			Authentication authentication)
	{
		User user = userService.findUserByEmail(authentication.getName());
		MealPlan mealPlan = mealPlanService.findMealPlan(mealPlanId);

		if (mealPlan.getCreatedBy() != user)
		{
			throw new AccessDeniedException("Innskráður notandi hefur ekki aðgang að þessu matarplani");
		}

		model.addAttribute("mealPlan", mealPlan);
		model.addAttribute("recipeList", recipeService.allRecipes());
		return "mealplan/show";
	}

	/**
	 * Updates a specific meal plan with new information
	 * 
	 * @param mealPlanId
	 *            unique identifier for the meal plan to be edited
	 * @param recipeId
	 *            unique identifier for the recipe to be added to the meal plan
	 * @param dateForRecipe
	 *            the date for which the meal is planned to be had
	 * @param model
	 *            the model that contains all the necessary information
	 * @return the site that allows editing of meal plans
	 */
	@RequestMapping(value = "/{mealPlanId}/edit", method = RequestMethod.POST)
	public ModelAndView editDateMeal(@PathVariable(value = "mealPlanId") long mealPlanId,
			@RequestParam(value = "recipeId", required = true) long recipeId,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateForRecipe, ModelMap model,
			Authentication authentication)
	{
		User user = userService.findUserByEmail(authentication.getName());
		MealPlan mealPlan = mealPlanService.findMealPlan(mealPlanId);

		if (mealPlan.getCreatedBy() != user)
		{
			throw new AccessDeniedException("Innskráður notandi hefur ekki aðgang að þessu matarplani");
		}

		Recipe newRecipe = recipeService.findRecipe(recipeId);

		MealPlanItemWrapper wrapper = new MealPlanItemWrapper(mealPlan, newRecipe, dateForRecipe);
		mealPlanItemService.addMealPlanItem(wrapper);

		return new ModelAndView("redirect:/mealplan/" + mealPlanId);
	}

	/**
	 * Delete a meal plan from database
	 * 
	 * @param mealPlanId
	 *            of the meal plan to be deleted
	 * @param authentication
	 *            for the user
	 * @return to index of all meal plans for said user
	 */
	@RequestMapping(value = "/deleteMealPlan/{mealPlanId}")
	public String deleteMealPlan(@PathVariable(value = "mealPlanId") long mealPlanId, Authentication authentication)
	{
		User user = userService.findUserByEmail(authentication.getName());
		MealPlan mealPlan = mealPlanService.findMealPlan(mealPlanId);

		if (mealPlan.getCreatedBy() != user)
		{
			throw new AccessDeniedException("Innskráður notandi hefur ekki aðgang að þessu matarplani");
		}

		mealPlanService.deleteMealPlan(mealPlanId);
		return "mealplan/index";
	}

	/**
	 * Add a list of meal plans to the model which can be displayed on the page
	 * 
	 * @param model
	 *            the model which the list of meal plans is to be added to.
	 */
	private void addMealPlanListToModel(Model model, User user)
	{
		List<MealPlan> mealPlanList = mealPlanService.allMealPlans(user);
		model.addAttribute("mealPlanList", mealPlanList);
	}

	/**
	 * Converts a date from a string to Date
	 * 
	 * @param d
	 *            is the String that is to be converted to a Date object.
	 * @return d on date format
	 * @throws ParseException
	 */
	private Date convertToDate(String d) throws ParseException
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.parse(d);
	}

	/**
	 * Creates a list of the days between two days, from and to dates are included
	 * 
	 * @param from
	 *            is the date that you start counting from
	 * @param to
	 *            is final date of the date count
	 * @return list that contains all the dates between and including the from and
	 *         to dates
	 */
	private ArrayList<Date> generateDatesBetween(Date from, Date to)
	{
		Calendar cal = Calendar.getInstance();
		ArrayList<Date> d = new ArrayList<Date>();
		cal.setTime(from);
		while (cal.getTime().before(to))
		{
			d.add(cal.getTime());
			cal.add(Calendar.DATE, 1);
		}
		d.add(cal.getTime());
		return d;
	}
}
