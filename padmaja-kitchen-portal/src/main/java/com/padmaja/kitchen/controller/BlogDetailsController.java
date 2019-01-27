package com.padmaja.kitchen.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.padmaja.kitchen.model.BlogDetailsDto;
import com.padmaja.kitchen.model.FileBucket;
import com.padmaja.kitchen.persist.entity.BlogDetails;
import com.padmaja.kitchen.service.BlogDetailsService;
import com.padmaja.kitchen.util.DateUtil;

@Controller
@MultipartConfig(maxFileSize = 16177215)
public class BlogDetailsController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	/*@Autowired private DozerBeanMapper mapper;*/
	@Autowired BlogDetailsService blogDetailsService;
	@Autowired private MessageSource ms;
	
	@RequestMapping(value="/detail", method = RequestMethod.GET)
	public String getBlogDetails(@RequestParam String id,ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		FileBucket fileModel = new FileBucket();
		model.addAttribute("fileBucket", fileModel);
		BlogDetailsDto details = new BlogDetailsDto();
		if(id!=null){
			BlogDetails detailsFromDb =blogDetailsService.getById(Long.valueOf(id));
			//details =mapper.map(detailsFromDb, BlogDetailsDto.class);
			details.setTitle(detailsFromDb.getTitle());
			model.addAttribute("details", details);
		}
		
		return "blogDetails";
	}

	@RequestMapping(value="/detailList", method = RequestMethod.GET)
	public String getBlogDetailsList(@RequestParam String id,ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		FileBucket fileModel = new FileBucket();
		model.addAttribute("fileBucket", fileModel);
		logger.info("detailList get method call");
		List<BlogDetailsDto> imageDetailList= new ArrayList<BlogDetailsDto>();
		if(id!=null && id.equalsIgnoreCase("popular")){
			List<BlogDetails> blogDetailsList =blogDetailsService.findAll();
			for (BlogDetails blogDetails : blogDetailsList) {
				BlogDetailsDto dto= new BlogDetailsDto();
				dto.setBlogName(blogDetails.getBlogName());
				dto.setCrtDate(""+blogDetails.getCrtTs());
				dto.setId(blogDetails.getId());
				try {
					dto.setImageString(new String(Base64.encodeBase64(blogDetails.getBlogImage()), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				imageDetailList.add(dto);
			}
			System.out.println("getting from session recentImageList");
			model.addAttribute("imageDetailList", imageDetailList);
		}else if(id!=null && id.equalsIgnoreCase("recently")){
			List<BlogDetails> blogDetailsList =blogDetailsService.findAll();
			for (BlogDetails blogDetails : blogDetailsList) {
				BlogDetailsDto dto= new BlogDetailsDto();
				dto.setBlogName(blogDetails.getBlogName());
				dto.setCrtDate(""+blogDetails.getCrtTs());
				dto.setId(blogDetails.getId());
				try {
					dto.setImageString(new String(Base64.encodeBase64(blogDetails.getBlogImage()), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				imageDetailList.add(dto);
			}
			System.out.println("getting from session recentImageList");
			model.addAttribute("imageDetailList", imageDetailList);
		}else{
			//new
			List<BlogDetails> blogDetailsList =blogDetailsService.findAll();
			for (BlogDetails blogDetails : blogDetailsList) {
				BlogDetailsDto dto= new BlogDetailsDto();
				dto.setBlogName(blogDetails.getBlogName());
				dto.setCrtDate(""+blogDetails.getCrtTs());
				dto.setId(blogDetails.getId());
				try {
					dto.setImageString(new String(Base64.encodeBase64(blogDetails.getBlogImage()), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				imageDetailList.add(dto);
			}
			System.out.println("getting from session recentImageList");
			model.addAttribute("imageDetailList", imageDetailList);
			
		}
		
		
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
