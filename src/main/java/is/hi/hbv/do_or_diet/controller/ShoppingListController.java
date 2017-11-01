/**
 * ShoppingListController enables the user to interact with shopping lists
 * 
 * @author Eiður Örn Gunnarsson eog26@hi.is
 */
package is.hi.hbv.do_or_diet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import is.hi.hbv.do_or_diet.model.MealPlan;
import is.hi.hbv.do_or_diet.model.ShoppingList;
import is.hi.hbv.do_or_diet.model.User;
import is.hi.hbv.do_or_diet.service.MealPlanService;
import is.hi.hbv.do_or_diet.service.ShoppingListService;
import is.hi.hbv.do_or_diet.service.UserService;

@Controller
@RequestMapping("/shoppinglist")
public class ShoppingListController
{
	// Instance of the meal plan repository used to get meal plans
	@Autowired
	MealPlanService mealPlanService;

	// Instance of the shopping list service used to create and get shopping lists
	@Autowired
	ShoppingListService shoppingListService;

	// Instance of the user repository used to get the current user
	@Autowired
	UserService userService;

	/**
	 * Index page for the meal plans, shows a list of meal plans
	 * 
	 * @param model
	 *            the model that contains all the necessary information
	 * @return
	 */
	@RequestMapping("")
	public String indexPage(Model model, Authentication authentication)
	{
		User user = userService.findUserByEmail(authentication.getName());

		List<ShoppingList> shoppingLists = shoppingListService.allShoppingLists(user);

		model.addAttribute("shoppingLists", shoppingLists);

		return "shoppinglist/index";
	}

	@RequestMapping("/{shoppingListId}")
	public String showMealPlan(@PathVariable(value = "shoppingListId") long shoppingListId, ModelMap model,
			Authentication authentication)
	{
		User user = userService.findUserByEmail(authentication.getName());
		ShoppingList sl = shoppingListService.findShoppingList(shoppingListId);

		if (sl.getOwner() != user)
		{
			throw new AccessDeniedException("Innskráður notandi hefur ekki aðgang að þessum innkaupalista!");
		}

		model.addAttribute("shoppingList", sl);

		return "shoppinglist/show";
	}

	@RequestMapping("/createFromMealPlan/{mealPlanId}")
	public ModelAndView createFromMealPlan(@PathVariable(value = "mealPlanId") long mealPlanId, ModelMap model,
			Authentication authentication)
	{
		MealPlan mealPlan = mealPlanService.findMealPlan(mealPlanId);
		model.addAttribute("mealPlan", mealPlan);
		User user = userService.findUserByEmail(authentication.getName());

		ShoppingList sl = shoppingListService.createFromMealPlan(mealPlan, user);

		model.addAttribute("shoppingList", sl);

		return new ModelAndView("redirect:/shoppinglist/" + sl.getId());
	}
}
