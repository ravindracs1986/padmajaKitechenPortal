package com.padmaja.kitchen.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.padmaja.kitchen.persist.entity.VideoDetails;
import com.padmaja.kitchen.service.HomeVideoService;



@Controller
@RequestMapping("/")
public class AppController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired HomeVideoService homeVideoService;
	
	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	public String homePage(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		List<VideoDetails> videoListFromSession = (List<VideoDetails>) session.getAttribute("videoList");
		if (videoListFromSession != null) {
			System.out.println("getting from session&&&&&&&");
			request.setAttribute("videoList", videoListFromSession);
		} else {
			System.out.println("getting from database@@@@@@@@@@@@");
			List<VideoDetails> videoList = homeVideoService.findAll();
			session.setAttribute("videoList", videoList);
			model.addAttribute("videoList", videoList);
		}
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