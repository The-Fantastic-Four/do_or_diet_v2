/**
 * UserController enables the user to interact with their user accounts
 * 
 * @author Eiður Örn Gunnarsson eog26@hi.is
 * @author Ragnheiður Ásta Karlsdóttir rak4@hi.is
 * @author Viktor Alex Brynjarsson vab18@hi.is
 */
package is.hi.hbv.do_or_diet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import is.hi.hbv.do_or_diet.model.User;
import is.hi.hbv.do_or_diet.service.UserService;
import is.hi.hbv.do_or_diet.service.UserServiceImp;

@Controller
public class UserController
{
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration()
	{
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@RequestParam String username, String password, String email, ModelMap model)
	{
		User user = new User(username, password, email);
		System.out.println("Numero uno");
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists == null)
		{
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "Skráning tókst");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");
			System.out.println("Numero dos");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView home()
	{
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getUsername() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}
}
