package com.jingle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Henry Harvey
 * The HomeController manages behavior related to the home page
 */

@Controller
@RequestMapping("/home")
public class HomeController {

	/**
	 * Redirects to home page.
	 * 
	 * @return ModelAndView	home mav
	 */
	@GetMapping(value = { "/" })
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
