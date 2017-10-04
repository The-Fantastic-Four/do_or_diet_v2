/**
 * WelcomeController displays the first page the user sees
 * @author Viktor Alex Brynjarsson vab18@hi.is
 */
package is.hi.hbv.do_or_diet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WelcomeController 
{	
	// Index page for the whole site, shows links to other pages
	@RequestMapping("")
	public String indexPage()
	{
		return "welcome/index";
	}
}
