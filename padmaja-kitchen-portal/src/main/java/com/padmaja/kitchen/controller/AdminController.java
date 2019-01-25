package com.padmaja.kitchen.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

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
import com.padmaja.kitchen.util.FileValidator;
import com.padmaja.kitchen.util.MultiFileValidator;

@Controller
public class AdminController {

	private static String UPLOAD_LOCATION="E:\\WorkSpaceISC\\Doc_Signing\\Doc_sign_Doc\\UploadLocTemp";
	
	@Autowired
	FileValidator fileValidator;
	

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

	
	/*@RequestMapping(value="/multiUpload", method = RequestMethod.GET)
	public String getMultiUploadPage(ModelMap model) {
		MultiFileBucket filesModel = new MultiFileBucket();
		model.addAttribute("multiFileBucket", filesModel);
		return "multiFileUploader";
	}

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
