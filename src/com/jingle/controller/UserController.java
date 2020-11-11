package com.jingle.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jingle.business.UserBusinessInterface;
import com.jingle.model.Credentials;
import com.jingle.model.User;

/**
 * @author Josh Van de Walle
 * The UserController manages behavior related to user CRUD operations including login and registration
 */

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private HttpSession httpSession;

	UserBusinessInterface userBusinessService;

	@Autowired
	public void setUserBusinessService(UserBusinessInterface userBusinessService) {
		this.userBusinessService = userBusinessService;
	}

	@GetMapping(value = { "/", "/home" })
	public ModelAndView handleHomePageDisplay() {
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("home");
			return mav;
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	@GetMapping("/login")
	public ModelAndView handleDisplayLoginPage() {
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("userLogin");
			mav.addObject("credentials", new Credentials());
			httpSession.removeAttribute("sessionUser");
			return mav;
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	/**
	 * this method manages behavior related to logging-in
	 * @param credentials Credentials the credentials to attempt to login
	 * @param result the validation result
	 * @return ModelAndView the appropriate view and model combo
	 */
	@PostMapping("/handleLogin")
	public ModelAndView handleLogin(@Valid @ModelAttribute("credentials") Credentials credentials,
			BindingResult result) {
		try {
			if (result.hasErrors()) {
				return new ModelAndView("userLogin", "credentials", credentials);
			}
			User user = userBusinessService.loginUser(new User(-1, "", "", "", "", credentials));
			if (user == null) {
				return new ModelAndView("userLogin", "user", user);
			}
			httpSession.setAttribute("sessionUser", user);
			return new ModelAndView("home", "credentials", user.getCredentials());
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	@GetMapping("/handleLogin")
	public ModelAndView handleRefreshLogin() {
		return this.handleDisplayLoginPage();
	}

	@GetMapping("/register")
	public ModelAndView handleDisplayRegistrationPage() {
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("userRegister");
			mav.addObject("user", new User());
			mav.addObject("credentials", new Credentials());
			return mav;
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	/**
	 * this method manages behavior related to registration
	 * @param user User the user to attempt to register
	 * @param result the validation result
	 * @return ModelAndView the appropriate view and model combo
	 */
	@PostMapping("/handleRegister")
	public ModelAndView handleRegister(@Valid @ModelAttribute("user") User user, BindingResult result) {
		try {
			if (result.hasErrors()) {
				return new ModelAndView("userRegister", "user", user);
			}
			if (userBusinessService.registerUser(user) != 1) {
				return new ModelAndView("userRegister", "user", user);
			}
			return new ModelAndView("login", "credentials", user.getCredentials());
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	@GetMapping("/handleRegister")
	public ModelAndView handleRefreshRegister() {
		return this.handleDisplayRegistrationPage();
	}

}
