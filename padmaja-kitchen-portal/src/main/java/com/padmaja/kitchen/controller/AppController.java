package com.padmaja.kitchen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/")
public class AppController {

	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		return "home";
	}

	@RequestMapping(value = { "/vegRecipe"}, method = RequestMethod.GET)
	public String vegRecipePage(ModelMap model) {
		return "vegRecipe";
	}
	
	@RequestMapping(value = { "/nonVegRecipe"}, method = RequestMethod.GET)
	public String nonVegRecipePage(ModelMap model) {
		return "nonVegRecipe";
	}

	@RequestMapping(value = { "/about"}, method = RequestMethod.GET)
	public String aboutPage(ModelMap model) {
		return "about";
	}
	
	@RequestMapping(value = { "/contact"}, method = RequestMethod.GET)
	public String contactPage(ModelMap model) {
		return "contact";
	}
	
}