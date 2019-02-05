package com.padmaja.kitchen.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.padmaja.kitchen.model.BlogDetailsDto;
import com.padmaja.kitchen.persist.entity.BlogDetails;
import com.padmaja.kitchen.persist.entity.VideoDetails;
import com.padmaja.kitchen.service.BlogDetailsService;
import com.padmaja.kitchen.service.HomeVideoService;



@Controller
@RequestMapping("/")
public class AppController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired HomeVideoService homeVideoService;
	@Autowired BlogDetailsService blogDetailsService;
	
	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	public String homePage(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		List<VideoDetails> latestVideoListFromSession = (List<VideoDetails>) session.getAttribute("videoList");
		List<VideoDetails> topVideoListFromSession = (List<VideoDetails>) session.getAttribute("topvideoList");
		List<BlogDetailsDto> blogDetailsDtoFromSession = (List<BlogDetailsDto>) session.getAttribute("popularImageList");
		List<BlogDetailsDto> recentFromSession = (List<BlogDetailsDto>) session.getAttribute("recentlyImageList");
		List<BlogDetailsDto> newFromSession = (List<BlogDetailsDto>) session.getAttribute("newImageList");
		if (latestVideoListFromSession != null) {
			System.out.println("getting from session&&&&&&&");
			request.setAttribute("videoList", latestVideoListFromSession);
		} else {
			System.out.println("getting from database@@@@@@@@@@@@");
			List<VideoDetails> videoList = homeVideoService.findLatestVideos();
			session.setAttribute("videoList", videoList);
			model.addAttribute("videoList", videoList);
		}
		//top video
		if (topVideoListFromSession != null) {
			System.out.println("getting from topvideoList &&&&&&&");
			request.setAttribute("topvideoList", topVideoListFromSession);
		} else {
			System.out.println("getting from database@@@@@@@@@@@@");
			List<VideoDetails> topvideoList = homeVideoService.findTopVideos();
			session.setAttribute("topvideoList", topvideoList);
			model.addAttribute("topvideoList", topvideoList);
		}
		
		
		if(blogDetailsDtoFromSession!=null){
			System.out.println("getting from session popularImageList");
			model.addAttribute("popularImageList", blogDetailsDtoFromSession);
		}else{
			List<BlogDetailsDto> imageList =getPopularimage();
			session.setAttribute("popularImageList", imageList);
			model.addAttribute("popularImageList", imageList);
		}
		//recent
		if(recentFromSession!=null){
			System.out.println("getting from session recentImageList");
			model.addAttribute("recentlyImageList", recentFromSession);
		}else{
			List<BlogDetailsDto> imageList =getRecentlyimage();
			session.setAttribute("recentlyImageList", imageList);
			model.addAttribute("recentlyImageList", imageList);
		}
		//new
		if(newFromSession!=null){
			System.out.println("getting from session newImageList");
			model.addAttribute("newImageList", newFromSession);
		}else{
			List<BlogDetailsDto> imageList =getNewimage();
			session.setAttribute("newImageList", imageList);
			model.addAttribute("newImageList", imageList);
		}
		
		
		return "home";
	}

	@RequestMapping(value = { "/vegRecipe"}, method = RequestMethod.GET)
	public String vegRecipePage(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		List<VideoDetails> vegVideoListFromSession = (List<VideoDetails>) session.getAttribute("vegVideoList");
		List<BlogDetailsDto> blogDetailsDtoFromSession = (List<BlogDetailsDto>) session.getAttribute("popularImageList");
		List<BlogDetailsDto> recentFromSession = (List<BlogDetailsDto>) session.getAttribute("recentlyImageList");
		List<BlogDetailsDto> newFromSession = (List<BlogDetailsDto>) session.getAttribute("newImageList");
		if (vegVideoListFromSession != null) {
			System.out.println("getting from session&&&&&&&");
			request.setAttribute("videoList", vegVideoListFromSession);
		} else {
			System.out.println("getting from database@@@@@@@@@@@@");
			List<VideoDetails> vegVideoList = homeVideoService.findbyCategory("VEG");
			session.setAttribute("vegVideoList", vegVideoList);
			model.addAttribute("videoList", vegVideoList);
		}
		if(blogDetailsDtoFromSession!=null){
			System.out.println("getting from session popularImageList");
			model.addAttribute("popularImageList", blogDetailsDtoFromSession);
		}else{
			List<BlogDetailsDto> imageList =getPopularimage();
			session.setAttribute("popularImageList", imageList);
			model.addAttribute("popularImageList", imageList);
		}
		//recent
		if(recentFromSession!=null){
			System.out.println("getting from session recentImageList");
			model.addAttribute("recentlyImageList", recentFromSession);
		}else{
			List<BlogDetailsDto> imageList =getRecentlyimage();
			session.setAttribute("recentlyImageList", imageList);
			model.addAttribute("recentlyImageList", imageList);
		}
		//new
		if(newFromSession!=null){
			System.out.println("getting from session newImageList");
			model.addAttribute("newImageList", newFromSession);
		}else{
			List<BlogDetailsDto> imageList =getNewimage();
			session.setAttribute("newImageList", imageList);
			model.addAttribute("newImageList", imageList);
		}
		return "vegRecipe";
	}
	
	@RequestMapping(value = { "/nonVegRecipe"}, method = RequestMethod.GET)
	public String nonVegRecipePage(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		List<VideoDetails> nonvegvideoListFromSession = (List<VideoDetails>) session.getAttribute("nonVegvideoList");
		List<BlogDetailsDto> blogDetailsDtoFromSession = (List<BlogDetailsDto>) session.getAttribute("popularImageList");
		List<BlogDetailsDto> recentFromSession = (List<BlogDetailsDto>) session.getAttribute("recentlyImageList");
		List<BlogDetailsDto> newFromSession = (List<BlogDetailsDto>) session.getAttribute("newImageList");
		if (nonvegvideoListFromSession != null) {
			System.out.println("getting from session&&&&&&&");
			request.setAttribute("videoList", nonvegvideoListFromSession);
		} else {
			System.out.println("getting from database@@@@@@@@@@@@");
			List<VideoDetails> nonVegvideoList = homeVideoService.findbyCategory("NONVEG");
			session.setAttribute("nonVegvideoList", nonVegvideoList);
			model.addAttribute("videoList", nonVegvideoList);
		}
		if(blogDetailsDtoFromSession!=null){
			System.out.println("getting from session popularImageList");
			model.addAttribute("popularImageList", blogDetailsDtoFromSession);
		}else{
			List<BlogDetailsDto> imageList =getPopularimage();
			session.setAttribute("popularImageList", imageList);
			model.addAttribute("popularImageList", imageList);
		}
		//recent
		if(recentFromSession!=null){
			System.out.println("getting from session recentImageList");
			model.addAttribute("recentlyImageList", recentFromSession);
		}else{
			List<BlogDetailsDto> imageList =getRecentlyimage();
			session.setAttribute("recentlyImageList", imageList);
			model.addAttribute("recentlyImageList", imageList);
		}
		//new
		if(newFromSession!=null){
			System.out.println("getting from session newImageList");
			model.addAttribute("newImageList", newFromSession);
		}else{
			List<BlogDetailsDto> imageList =getNewimage();
			session.setAttribute("newImageList", imageList);
			model.addAttribute("newImageList", imageList);
		}
		
		return "nonVegRecipe";
	}

	@RequestMapping(value = { "/about"}, method = RequestMethod.GET)
	public String aboutPage(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		List<VideoDetails> videoListFromSession = (List<VideoDetails>) session.getAttribute("videoList");
		List<BlogDetailsDto> blogDetailsDtoFromSession = (List<BlogDetailsDto>) session.getAttribute("popularImageList");
		List<BlogDetailsDto> recentFromSession = (List<BlogDetailsDto>) session.getAttribute("recentlyImageList");
		List<BlogDetailsDto> newFromSession = (List<BlogDetailsDto>) session.getAttribute("newImageList");
		if (videoListFromSession != null) {
			System.out.println("getting from session&&&&&&&");
			request.setAttribute("videoList", videoListFromSession);
		} else {
			System.out.println("getting from database@@@@@@@@@@@@");
			List<VideoDetails> videoList = homeVideoService.findAll();
			session.setAttribute("videoList", videoList);
			model.addAttribute("videoList", videoList);
		}
		if(blogDetailsDtoFromSession!=null){
			System.out.println("getting from session popularImageList");
			model.addAttribute("popularImageList", blogDetailsDtoFromSession);
		}else{
			List<BlogDetailsDto> imageList =getPopularimage();
			session.setAttribute("popularImageList", imageList);
			model.addAttribute("popularImageList", imageList);
		}
		//recent
		if(recentFromSession!=null){
			System.out.println("getting from session recentImageList");
			model.addAttribute("recentlyImageList", recentFromSession);
		}else{
			List<BlogDetailsDto> imageList =getRecentlyimage();
			session.setAttribute("recentlyImageList", imageList);
			model.addAttribute("recentlyImageList", imageList);
		}
		//new
		if(newFromSession!=null){
			System.out.println("getting from session newImageList");
			model.addAttribute("newImageList", newFromSession);
		}else{
			List<BlogDetailsDto> imageList =getNewimage();
			session.setAttribute("newImageList", imageList);
			model.addAttribute("newImageList", imageList);
		}
		
		return "about";
	}
	
	@RequestMapping(value = { "/contact"}, method = RequestMethod.GET)
	public String contactPage(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		List<VideoDetails> videoListFromSession = (List<VideoDetails>) session.getAttribute("videoList");
		List<BlogDetailsDto> blogDetailsDtoFromSession = (List<BlogDetailsDto>) session.getAttribute("popularImageList");
		List<BlogDetailsDto> recentFromSession = (List<BlogDetailsDto>) session.getAttribute("recentlyImageList");
		List<BlogDetailsDto> newFromSession = (List<BlogDetailsDto>) session.getAttribute("newImageList");
		if (videoListFromSession != null) {
			System.out.println("getting from session&&&&&&&");
			request.setAttribute("videoList", videoListFromSession);
		} else {
			System.out.println("getting from database@@@@@@@@@@@@");
			List<VideoDetails> videoList = homeVideoService.findAll();
			session.setAttribute("videoList", videoList);
			model.addAttribute("videoList", videoList);
		}
		if(blogDetailsDtoFromSession!=null){
			System.out.println("getting from session popularImageList");
			model.addAttribute("popularImageList", blogDetailsDtoFromSession);
		}else{
			List<BlogDetailsDto> imageList =getPopularimage();
			session.setAttribute("popularImageList", imageList);
			model.addAttribute("popularImageList", imageList);
		}
		//recent
		if(recentFromSession!=null){
			System.out.println("getting from session recentImageList");
			model.addAttribute("recentlyImageList", recentFromSession);
		}else{
			List<BlogDetailsDto> imageList =getRecentlyimage();
			session.setAttribute("recentlyImageList", imageList);
			model.addAttribute("recentlyImageList", imageList);
		}
		//new
		if(newFromSession!=null){
			System.out.println("getting from session newImageList");
			model.addAttribute("newImageList", newFromSession);
		}else{
			List<BlogDetailsDto> imageList =getNewimage();
			session.setAttribute("newImageList", imageList);
			model.addAttribute("newImageList", imageList);
		}
		
		return "contact";
	}
	
	@RequestMapping(value = { "/getPopularimage"}, method = RequestMethod.GET)
	public List<BlogDetailsDto> getPopularimage() {
		List<BlogDetailsDto> topImageList= new ArrayList<BlogDetailsDto>();
		List<BlogDetails> blogDetailsList =blogDetailsService.getPopularLimit();
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
			topImageList.add(dto);
		}
		
		
		return topImageList;
	}
	
	@RequestMapping(value = { "/getRecentlyimage"}, method = RequestMethod.GET)
	public List<BlogDetailsDto> getRecentlyimage() {
		List<BlogDetailsDto> topImageList= new ArrayList<BlogDetailsDto>();
		List<BlogDetails> blogDetailsList =blogDetailsService.getRecentLimit();
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
			topImageList.add(dto);
		}
		
		
		return topImageList;
	}
	
	@RequestMapping(value = { "/getNewimage"}, method = RequestMethod.GET)
	public List<BlogDetailsDto> getNewimage() {
		List<BlogDetailsDto> topImageList= new ArrayList<BlogDetailsDto>();
		List<BlogDetails> blogDetailsList =blogDetailsService.getNewLimit();
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
			topImageList.add(dto);
		}
		
		
		return topImageList;
	}
	
}