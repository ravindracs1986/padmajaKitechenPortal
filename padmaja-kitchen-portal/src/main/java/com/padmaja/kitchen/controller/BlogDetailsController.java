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
public class BlogDetailsController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	@Autowired HomeVideoService homeVideoService;

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
	public String saveBlogDetails(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		FileBucket fileModel = new FileBucket();
		model.addAttribute("fileBucket", fileModel);
		return "adminHome";
	}
	
	
}
