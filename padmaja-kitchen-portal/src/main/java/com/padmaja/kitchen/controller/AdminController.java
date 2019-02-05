package com.padmaja.kitchen.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.padmaja.kitchen.model.FileBucket;
import com.padmaja.kitchen.model.Login;
import com.padmaja.kitchen.persist.entity.VideoDetails;
import com.padmaja.kitchen.service.HomeVideoService;
import com.padmaja.kitchen.util.DateUtil;
import com.padmaja.kitchen.util.FileValidator;
import com.padmaja.kitchen.util.MultiFileValidator;

@Controller
public class AdminController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	FileValidator fileValidator;
	@Autowired HomeVideoService homeVideoService;

	@Autowired
	MultiFileValidator multiFileValidator;

	
	@InitBinder("fileBucket")
	protected void initBinderFileBucket(WebDataBinder binder) {
	   binder.setValidator(fileValidator);
	}


	@InitBinder("multiFileBucket")
	protected void initBinderMultiFileBucket(WebDataBinder binder) {
	   binder.setValidator(multiFileValidator);
	}


	@RequestMapping(value="/admin", method = RequestMethod.GET)
	public String adminLogin(ModelMap model) {
		FileBucket fileModel = new FileBucket();
		model.addAttribute("fileBucket", fileModel);
		return "login";
	}

	@RequestMapping(value="/admin", method = RequestMethod.POST)
	public String singleFileUpload(@Valid FileBucket fileBucket, BindingResult result, ModelMap model,HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		Login userFromSession = (Login) session.getAttribute("user");
		if (username != null && password != null) {
			Boolean isUserFound = false;
			if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
				isUserFound = true;
				Login login = new Login();
				login.setEmail(username);
				login.setPassword(password);
				login.setUserFound(true);
				session.setAttribute("user", login);

			}

			if (isUserFound || userFromSession.isUserFound()) {
				return "adminHome";

			} else {
				request.setAttribute("loginErrorMessage", "UserName or Password is wrong");
				return "login";
			}

		} else if (userFromSession!=null && userFromSession.isUserFound()) {
			return "adminHome";

		} else {
			request.setAttribute("loginErrorMessage", "UserName or Password is wrong");
			return "login";
		}
		
		
		
	}

	
	@RequestMapping(value="/saveVideo", method = RequestMethod.POST)
	public String getMultiUploadPage(@Valid FileBucket fileBucket,ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		logger.info("Saving videos");
		
		String category = request.getParameter("category");
		String videoName = request.getParameter("videoName");
		String videoUrl = request.getParameter("videoUrl");
		String youTubeId = request.getParameter("youTubeId");
		String view = request.getParameter("youTubeView");
		String like = request.getParameter("youTubeLike");
		
		if (category!=null && videoName!=null && videoUrl!=null && youTubeId!=null && view!=null && like!=null) {
			System.out.println("Saving video in database url:"+videoUrl);
			VideoDetails video = new VideoDetails();
			video.setVideoCategory(category);
			video.setVideoName(videoName);
			video.setVideoUrl(videoUrl);
			video.setYoutubeId(youTubeId);
			video.setYouTubeLike(Integer.parseInt(like));
			video.setYouTubeView(Integer.parseInt(view));
			video.setCrtTs(DateUtil.getSQLTimestamp());
			homeVideoService.createVideo(video);
		}
		
		return "adminHome";
	}
	
	
	@RequestMapping(value="/adminHome", method = RequestMethod.GET)
	public String adminHome(@Valid FileBucket fileBucket, BindingResult result, ModelMap model) throws IOException {

		return "adminHome";
		
	}

	
	@RequestMapping(value="/Logout", method = RequestMethod.GET)
	public String Logout(ModelMap model,HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Login userFromSession = (Login) session.getAttribute("user");

		if (userFromSession != null) {
			session.invalidate();

		}
		//response.sendRedirect("adminLogin.jsp");
		return "login";
	}
	
	
	
}
