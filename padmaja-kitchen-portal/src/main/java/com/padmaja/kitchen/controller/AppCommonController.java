package com.padmaja.kitchen.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.padmaja.kitchen.model.PopupBox;
import com.padmaja.kitchen.persist.entity.SubsorContacts;
import com.padmaja.kitchen.service.BlogDetailsService;
import com.padmaja.kitchen.service.HomeVideoService;
import com.padmaja.kitchen.service.SuborContactService;
import com.padmaja.kitchen.util.DateUtil;



@Controller
public class AppCommonController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired HomeVideoService homeVideoService;
	@Autowired BlogDetailsService blogDetailsService;
	@Autowired  SuborContactService suborContactService;
	
	@RequestMapping(value = {"/subscription"}, method = RequestMethod.GET)
	public ModelAndView homePage(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("redirect:" + "home");
		
	}
	
	
	
	@RequestMapping(value = {"/subscription"}, method = RequestMethod.POST)
	public ModelAndView subscription(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		String subEmail = request.getParameter("email");
		ModelAndView mav =new ModelAndView("popup");
		if(subEmail!=null && !StringUtils.isEmpty(subEmail)){
			SubsorContacts subsorContacts = new SubsorContacts();
			subsorContacts.setSubEmail(subEmail);
			subsorContacts.setCrtTs(DateUtil.getSQLTimestamp());
			suborContactService.create(subsorContacts);
			mav.addAllObjects(PopupBox.success(null, null,"Subscription Completed Successfully","home"));
			
		}else{
			mav.addAllObjects(PopupBox.error(null, null,"Subscription Fail, Please try again","home"));
		}
		return mav;
	}

	
	
}