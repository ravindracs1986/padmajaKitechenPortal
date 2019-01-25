package com.padmaja.kitchen.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;


import com.padmaja.kitchen.model.FileBucket;

import com.padmaja.kitchen.model.MultiFileBucket;

import com.padmaja.kitchen.persist.entity.VideoDetails;
import com.padmaja.kitchen.service.HomeVideoService;
import com.padmaja.kitchen.util.DateUtil;
import com.padmaja.kitchen.util.FileValidator;
import com.padmaja.kitchen.util.MultiFileValidator;

@Controller
public class AdminController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	private static String UPLOAD_LOCATION="E:\\WorkSpaceISC\\Doc_Signing\\Doc_sign_Doc\\UploadLocTemp";
	
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
	public String singleFileUpload(@Valid FileBucket fileBucket, BindingResult result, ModelMap model) throws IOException {

		return "adminHome";
		/*if (result.hasErrors()) {
			System.out.println("validation errors");
			return "singleFileUploader";
		} else {			
			System.out.println("Fetching file");
			MultipartFile multipartFile = fileBucket.getFile();

			
			// Writing byte array to OutputStream
	        OutputStream os = new ByteArrayOutputStream();
	        try {
	            os.write(fileBucket.getFile().getBytes());
	            os.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
			Path path = Paths.get(UPLOAD_LOCATION+"\\"+multipartFile.getOriginalFilename());

			Files.copy(path, os);
			
			
			String fileName = multipartFile.getOriginalFilename();
			model.addAttribute("fileName", fileName);
			return "success";
		}*/
	}

	
	@RequestMapping(value="/saveVideo", method = RequestMethod.POST)
	public String getMultiUploadPage(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		logger.info("Saving videos");
		
		String category = request.getParameter("category");
		String videoName = request.getParameter("videoName");
		String videoUrl = request.getParameter("videoUrl");
		String youTubeId = request.getParameter("youTubeId");
		
		if (category!=null && videoName!=null && videoUrl!=null && youTubeId!=null) {
			System.out.println("Saving video in database url:"+videoUrl);
			VideoDetails video = new VideoDetails();
			video.setVideoCategory(category);
			video.setVideoName(videoName);
			video.setVideoUrl(videoUrl);
			video.setYoutubeId(youTubeId);
			video.setCrtTs(DateUtil.getSQLTimestamp());
			homeVideoService.create(video);
		}
		
		return "adminHome";
	}
/*
	@RequestMapping(value="/multiUpload", method = RequestMethod.POST)
	public String multiFileUpload(@Valid MultiFileBucket multiFileBucket, BindingResult result, ModelMap model) throws IOException {

		
		if (result.hasErrors()) {
			System.out.println("validation errors in multi upload");
			return "multiFileUploader";
		} else {			
			System.out.println("Fetching files");
			List<String> fileNames= new ArrayList<String>();
			
			//Now do something with file...
			for(FileBucket bucket : multiFileBucket.getFiles()){
				FileCopyUtils.copy(bucket.getFile().getBytes(), new File(UPLOAD_LOCATION + bucket.getFile().getOriginalFilename()));
				fileNames.add(bucket.getFile().getOriginalFilename());
			}
			
			model.addAttribute("fileNames", fileNames);
			return "multiSuccess";
		}
	}*/
	
	
	
}
