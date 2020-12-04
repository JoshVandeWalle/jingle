package com.jingle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Josh Van de Walle
 * The UserController manages behavior related to user CRUD operations including login and registration
 */

@Controller
@RequestMapping("/home")
public class HomeController {
	@GetMapping(value = { "/"})
	public ModelAndView handleDisplayHomePage() {
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("home");
			return mav;
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}
}
