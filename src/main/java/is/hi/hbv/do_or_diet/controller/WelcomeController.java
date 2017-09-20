package is.hi.hbv.do_or_diet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WelcomeController {
	@RequestMapping("")
	public String indexPage()
	{
		return "welcome/index";
	}
}
