package com.padmaja.kitchen.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.padmaja.kitchen.model.FileBucket;
import com.padmaja.kitchen.persist.entity.BlogDetails;
import com.padmaja.kitchen.service.BlogDetailsService;
import com.padmaja.kitchen.util.DateUtil;

@Controller
@MultipartConfig(maxFileSize = 16177215)
public class BlogDetailsController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	@Autowired BlogDetailsService blogDetailsService;

	@RequestMapping(value="/detail", method = RequestMethod.GET)
	public String getBlogDetails(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		FileBucket fileModel = new FileBucket();
		model.addAttribute("fileBucket", fileModel);
		return "blogDetails";
	}

	@RequestMapping(value="/detailList", method = RequestMethod.GET)
	public String getBlogDetailsList(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		FileBucket fileModel = new FileBucket();
		model.addAttribute("fileBucket", fileModel);
		return "blogDetailsList";
	}
	
	@RequestMapping(value="/saveBlog", method = RequestMethod.POST)
	public String saveBlogDetails(@Valid FileBucket fileBucket,ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		
		logger.info("blog save method called");
		String blogName = request.getParameter("blogName");
		String title = request.getParameter("title");
		String paragraphOne = request.getParameter("paragraphOne");
		String paragraphTwo = request.getParameter("paragraphTwo");
		
		String imageOneUrl = request.getParameter("imageOneUrl");
		String paragraphThree = request.getParameter("paragraphThree");
		String imageTwoUrl = request.getParameter("imageTwoUrl");
		String paragraphFour = request.getParameter("paragraphFour");
		
		String paragraphFive = request.getParameter("paragraphFive");
		String paragraphSix = request.getParameter("paragraphSix");
		String youTubeVideoTitle = request.getParameter("youTubeVideoTitle");
		String youTubeVideoUrl = request.getParameter("youTubeVideoUrl");
		String recipeCardTitle = request.getParameter("recipeCardTitle");
		String recipeCardInsideTitle = request.getParameter("recipeCardInsideTitle");
		String ingredientsDetails = request.getParameter("ingredientsDetails");
		String instructionsDetails = request.getParameter("instructionsDetails");
		String notes = request.getParameter("notes");
		String category = request.getParameter("category");
		
		try {
			byte[] blogImage =fileBucket.getFile().getBytes();
			
			
			BlogDetails blogDetails =new BlogDetails();
			blogDetails.setBlogImage(blogImage);
			blogDetails.setBlogName(blogName);
			blogDetails.setTitle(title);
			blogDetails.setImageOneUrl(imageOneUrl);
			blogDetails.setImageTwoUrl(imageTwoUrl);
			blogDetails.setParagraphOne(paragraphOne);
			blogDetails.setParagraphTwo(paragraphTwo);
			blogDetails.setParagraphThree(paragraphThree);
			blogDetails.setParagraphFour(paragraphFour);
			blogDetails.setParagraphFive(paragraphFive);
			blogDetails.setParagraphSix(paragraphSix);
			blogDetails.setYouTubeVideoTitle(youTubeVideoTitle);
			blogDetails.setYouTubeVideoUrl(youTubeVideoUrl);
			blogDetails.setRecipeCardTitle(recipeCardTitle);
			blogDetails.setRecipeCardInsideTitle(recipeCardInsideTitle);
			blogDetails.setIngredientsDetails(ingredientsDetails);
			blogDetails.setInstructionsDetails(instructionsDetails);
			blogDetails.setNotes(notes);
			blogDetails.setCategory(category);
			blogDetails.setCrtTs(DateUtil.getSQLTimestamp());
			blogDetailsService.create(blogDetails);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "adminHome";
	}
	
	
}
