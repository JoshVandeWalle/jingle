package com.jingle.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jingle.business.UserBusinessService;
import com.jingle.model.Credentials;
import com.jingle.model.User;

/**
 * 
 * @author Josh Van de Walle
 * The UserController manages behavior related to user CRUD operations including login and registration
 */

@Controller
@RequestMapping("/user")
public class UserController 
{
//	@Autowired 
	UserBusinessService service; 
	
	/**
	 * this method manages behavior related to registration
	 * @param user User the user to attempt to register
	 * @param result the validation result
	 * @return ModelAndView the appropriate view and model combo
	 */
	@PostMapping("/handleRegister")
	public ModelAndView handleRegister(@Valid @ModelAttribute("user") User user, BindingResult result)
	{
		service = new UserBusinessService();
		
		if (result.hasErrors())
		{
			return new ModelAndView("register", "user", user);
		}
		
		if (service.register(user) == 0)
		{
			return new ModelAndView("home", "user", user);
		}
		
		else 
		{
			return new ModelAndView("register", "user", user);
		}
	}
	
	@GetMapping("/")
	public ModelAndView index() {
		return new ModelAndView("register");
	}
	
	@GetMapping("/handleRegister")
	public ModelAndView handleRefreshRegister()
	{
		return this.handleDisplayRegistrationPage();
	}
	
	/**
	 * this method manages behavior related to logging-in
	 * @param credentials Credentials the credentials to attempt to login
	 * @param result the validation result
	 * @return ModelAndView the appropriate view and model combo
	 */
	@PostMapping("/handleLogin")
	public ModelAndView handleLogin(@Valid @ModelAttribute("credentials") Credentials credentials, BindingResult result)
	{
		service = new UserBusinessService();
		
		if (result.hasErrors())
		{
			return new ModelAndView("login", "credentials", credentials);
		}
		
		User user = new User(-1, "", "", "", "", credentials);
		user = service.login(user);
		
		if (user == null)
		{
			return new ModelAndView("home", "user", user);
		}
		
		else 
		{
			return new ModelAndView("login", "credentials", user.getCredentials());
		}
	}
	
	@GetMapping("/handleLogin")
	public ModelAndView handleRefreshLogin()
	{
		return this.handleDisplayLoginPage();
	}
	
	@GetMapping("/register")
	public ModelAndView handleDisplayRegistrationPage()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("register");
		mav.addObject("user", new User());
		mav.addObject("credentials", new Credentials());
		
		return mav;
	}
	
	@GetMapping("/login")
	public ModelAndView handleDisplayLoginPage()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		mav.addObject("credentials", new Credentials());
		return mav;
	}
	
	@GetMapping("/home")
	public ModelAndView handleHomePageDisplay()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		return mav;
	}

}
