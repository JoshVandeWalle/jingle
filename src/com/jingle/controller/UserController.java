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
import com.jingle.model.SessionData;
import com.jingle.model.User;

/**
 * @author Josh Van de Walle
 * The UsergController manages behavior related to users and credentials
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

	/**
	 * Redirects to register page.
	 * 
	 * @return ModelAndView	register page + credentials + user mav
	 */
	@GetMapping("/register")
	public ModelAndView handleDisplayRegistrationForm() {
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("user_registration");
			mav.addObject("user", new User());
			mav.addObject("credentials", new Credentials());
			return mav;
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	/**
	 * Handles register and redirects to login.
	 * 
	 * @param user 			user to attempt to login
	 * @param result 		the validation result
	 * @return ModelAndView	login + credentials mav
	 */
	@PostMapping("/handleRegister")
	public ModelAndView handleRegisterUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
		try {
			if (result.hasErrors()) {
				return new ModelAndView("user_registration", "user", user);
			}
			if (userBusinessService.registerUser(user) != 1) {
				return new ModelAndView("user_registration", "user", user);
			}
			return new ModelAndView("user_login", "credentials", user.getCredentials());
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	/**
	 * Redirects to login page.
	 * 
	 * @return ModelAndView	login page + credentials mav
	 */
	@GetMapping("/login")
	public ModelAndView handleDisplayLoginForm() {
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("user_login");
			mav.addObject("credentials", new Credentials());
			httpSession.removeAttribute("sessionData");
			return mav;
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}
	
	/**
	 * Handles login and redirects to home.
	 * Sets the HTTP session variables.
	 * 
	 * @param credentials 	Credentials the credentials to attempt to login
	 * @param result 		the validation result
	 * @return ModelAndView	home + credentials mav
	 */
	@PostMapping("/handleLogin")
	public ModelAndView handleLoginUser(@Valid @ModelAttribute("credentials") Credentials credentials, BindingResult result) {
		try {
			if (result.hasErrors()) {
				return new ModelAndView("user_login", "credentials", credentials);
			}
			User user = userBusinessService.loginUser(new User(-1, "", "", "", "", credentials));
			if (user == null) {
				return new ModelAndView("user_login", "user", user);
			}
			SessionData sessionData = new SessionData(user.getId(), user.getFirstName(), user.getCredentials_id(), user.getCredentials().getUsername(), user.getCredentials().getRole());
			httpSession.setAttribute("sessionData", sessionData);
			return new ModelAndView("home", "credentials", user.getCredentials());
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	/**
	 * Redirects to profile page.
	 * 
	 * @return ModelAndView	profile page + user mav
	 */
	@GetMapping("/myProfile")
	public ModelAndView handleDisplayMyProfilePage() {
		try {
			User user = userBusinessService.getUser(new User(((SessionData) httpSession.getAttribute("sessionData")).getUsers_id(), "", "", "", "", ((SessionData) httpSession.getAttribute("sessionData")).getCredentials_id()));
			ModelAndView mav = new ModelAndView();
			mav.addObject("user", user);
			mav.setViewName("user_profile");
			return mav;
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	/**
	 * Redirects to profile page.
	 * 
	 * @param user 			User to view
	 * @return ModelAndView	profile + user mav
	 */
	@GetMapping("/profile")
	public ModelAndView handleDisplayProfilePage(@ModelAttribute("user") User user) {
		try {
			user = userBusinessService.getUser(user);
			ModelAndView mav = new ModelAndView();
			mav.addObject("user", user);
			mav.setViewName("user_profile");
			return mav;
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	/**
	 * Redirects to edit page.
	 * 
	 * @return ModelAndView	edit page + user mav
	 */
	@GetMapping("/edit")
	public ModelAndView handleDisplayEditForm(@ModelAttribute("user") User user) {
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("user_editForm");
			mav.addObject("user", userBusinessService.getUser(user));
			return mav;
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	/**
	 * Handles edit and redirects to profile.
	 * 
	 * @param user 			User to edit
	 * @param result 		the validation result
	 * @return ModelAndView	profile + user mav
	 */
	@PostMapping("/handleEdit")
	public ModelAndView handleEditUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
		try {
			if (result.hasErrors()) {
				return this.handleDisplayEditForm(user);
			}
			if (userBusinessService.editUser(user) != 1) {
				return this.handleDisplayEditForm(user);
			}
			return this.handleDisplayProfilePage(user);
		}

		catch (Exception e) {
			return new ModelAndView("error");
		}
	}

}
