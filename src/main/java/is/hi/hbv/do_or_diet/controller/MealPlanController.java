package is.hi.hbv.do_or_diet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mealplan")
public class MealPlanController {

		@RequestMapping("")
		public String indexPage()
		{
			return "mealplan/index";
		}
}
