package com.padmaja.kitchen.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
	private static final String IMAGE_DETAIL_LIST = "imageDetailList";
	private static final String BREAK_COUNT = "breakCount";
	private static final String LAUNCH_COUNT = "launchCount";
	private static final String DINAR_COUNT = "dinarCount";
	private static final String MORNING_COUNT = "morningCount";
	private static final String EVENING_COUNT = "eveningCount";
	private static final String EMPTY_STRING = "";
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
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
			details.setTitle(detailsFromDb.getTitle() != null ? detailsFromDb.getTitle() : EMPTY_STRING);
			details.setBlogName(detailsFromDb.getBlogName() != null ? detailsFromDb.getBlogName() : EMPTY_STRING);
			details.setCategory(detailsFromDb.getCategory() != null ? detailsFromDb.getCategory() : EMPTY_STRING);
			if(detailsFromDb.getCrtTs()!=null){
				//Date date=DateUtil.convertTimestampToDate(detailsFromDb.getCrtTs());
				details.setCrtDate(""+detailsFromDb.getCrtTs());
			}
			
			
			details.setDescription(detailsFromDb.getDescription() != null ? detailsFromDb.getDescription() : EMPTY_STRING);
			details.setImageOneUrl(detailsFromDb.getImageOneUrl() != null ? detailsFromDb.getImageOneUrl() : EMPTY_STRING);
			details.setImageTwoUrl(detailsFromDb.getImageTwoUrl() != null ? detailsFromDb.getImageTwoUrl() : EMPTY_STRING);
			
			details.setParagraphOne(detailsFromDb.getParagraphOne() != null ? detailsFromDb.getParagraphOne() : EMPTY_STRING);
			details.setParagraphTwo(detailsFromDb.getParagraphTwo() != null ? detailsFromDb.getParagraphTwo() : EMPTY_STRING);
			details.setParagraphThree(detailsFromDb.getParagraphThree() != null ? detailsFromDb.getParagraphThree() : EMPTY_STRING);
			details.setParagraphFour(detailsFromDb.getParagraphFour() != null ? detailsFromDb.getParagraphFour() : EMPTY_STRING);
			details.setParagraphFive(detailsFromDb.getParagraphFive() != null ? detailsFromDb.getParagraphFive() : EMPTY_STRING);
			details.setParagraphSix(detailsFromDb.getParagraphSix() != null ? detailsFromDb.getParagraphSix() : EMPTY_STRING);
			details.setIngredientsDetails(detailsFromDb.getIngredientsDetails() != null ? detailsFromDb.getIngredientsDetails() : EMPTY_STRING);
			details.setInstructionsDetails(detailsFromDb.getInstructionsDetails() != null ? detailsFromDb.getInstructionsDetails() : EMPTY_STRING);
			details.setNotes(detailsFromDb.getNotes() != null ? detailsFromDb.getNotes() : EMPTY_STRING);
			details.setRecipeCardInsideTitle(detailsFromDb.getRecipeCardInsideTitle() != null ? detailsFromDb.getRecipeCardInsideTitle() : EMPTY_STRING);
			details.setRecipeCardTitle(detailsFromDb.getRecipeCardTitle() != null ? detailsFromDb.getRecipeCardTitle() : EMPTY_STRING);
			details.setYouTubeVideoTitle(detailsFromDb.getYouTubeVideoTitle() != null ? detailsFromDb.getYouTubeVideoTitle() : EMPTY_STRING);
			details.setYouTubeVideoUrl(detailsFromDb.getYouTubeVideoUrl() != null ? detailsFromDb.getYouTubeVideoUrl() : EMPTY_STRING);
			
			details.setLaunchCount(getlaunchCount(request,response));
			details.setMorningCount(getmorningCount(request, response));
			details.setEveningCount(geteveningCount(request,response));
			details.setDinarCount(getdinarCreedsCount(request,response));
			details.setBrekFastCount(getbreakCount(request,response));
			details.setSweetsCount(getSweetsCount(request, response));
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
			List<BlogDetails> blogDetailsList =blogDetailsService.getPopularList();
			for (BlogDetails blogDetails : blogDetailsList) {
				BlogDetailsDto dto= new BlogDetailsDto();
				dto.setBlogName(blogDetails.getBlogName());
				dto.setTitle(blogDetails.getTitle());
				dto.setCategory(blogDetails.getCategory());
				dto.setDescription(blogDetails.getDescription());
				dto.setCrtDate(EMPTY_STRING+blogDetails.getCrtTs());
				dto.setId(blogDetails.getId());
				try {
					dto.setImageString(new String(Base64.encodeBase64(blogDetails.getBlogImage()), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				imageDetailList.add(dto);
			}
			
		}else if(id!=null && id.equalsIgnoreCase("recently")){
			List<BlogDetails> blogDetailsList =blogDetailsService.getRecentList();
			for (BlogDetails blogDetails : blogDetailsList) {
				BlogDetailsDto dto= new BlogDetailsDto();
				dto.setBlogName(blogDetails.getBlogName());
				dto.setTitle(blogDetails.getTitle());
				dto.setCategory(blogDetails.getCategory());
				dto.setDescription(blogDetails.getDescription());
				dto.setCrtDate(EMPTY_STRING+blogDetails.getCrtTs());
				dto.setId(blogDetails.getId());
				try {
					dto.setImageString(new String(Base64.encodeBase64(blogDetails.getBlogImage()), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				imageDetailList.add(dto);
			}
			
		}else{
			//new
			List<BlogDetails> blogDetailsList =blogDetailsService.getNewList();
			for (BlogDetails blogDetails : blogDetailsList) {
				BlogDetailsDto dto= new BlogDetailsDto();
				dto.setBlogName(blogDetails.getBlogName());
				dto.setTitle(blogDetails.getTitle());
				dto.setCategory(blogDetails.getCategory());
				dto.setDescription(blogDetails.getDescription());
				dto.setCrtDate(EMPTY_STRING+blogDetails.getCrtTs());
				dto.setId(blogDetails.getId());
				try {
					dto.setImageString(new String(Base64.encodeBase64(blogDetails.getBlogImage()), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				imageDetailList.add(dto);
			}
		
			
		}
		model.addAttribute(EVENING_COUNT, geteveningCount(request,response));
		model.addAttribute(MORNING_COUNT, getmorningCount(request,response));
		model.addAttribute(DINAR_COUNT, getdinarCreedsCount(request,response));
		model.addAttribute(LAUNCH_COUNT, getlaunchCount(request,response));
		model.addAttribute(BREAK_COUNT, getbreakCount(request,response));
		model.addAttribute(IMAGE_DETAIL_LIST, imageDetailList);
		
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
		String description = request.getParameter("description");
		String view = request.getParameter("youTubeView");
		String like = request.getParameter("youTubeLike");
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
			blogDetails.setDescription(description);
			blogDetails.setCrtTs(DateUtil.getSQLTimestamp());
			if(view!=null){
				blogDetails.setYouTubeView(Integer.parseInt(view));
			}
			if(like!=null){
				blogDetails.setYouTubeLike(Integer.parseInt(like));			
			}
			blogDetailsService.create(blogDetails);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "adminHome";
	}
	/**
	 * getBreakFastCreeds
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/breakFast-creeds", method = RequestMethod.GET)
	public String getBreakFastCreeds(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		FileBucket fileModel = new FileBucket();
		List<BlogDetailsDto> imageList =null;
		model.addAttribute("fileBucket", fileModel);
		logger.info("getBreakFastCreeds get method call");
		HttpSession session = request.getSession();
		imageList = (List<BlogDetailsDto>) session.getAttribute("breakFastCreedsList");
		List<BlogDetailsDto> imageDetailList= new ArrayList<BlogDetailsDto>();
		if(imageList!=null && imageList.size()>0){
			for (BlogDetailsDto dto : imageList) {
				imageDetailList.add(dto);
			}
			System.out.println("getting from session recentImageList");
			
		}else{
			List<BlogDetails> blogDetailsList =blogDetailsService.getByCategory("breakFast-creeds");
			for (BlogDetails blogDetails : blogDetailsList) {
				BlogDetailsDto dto= new BlogDetailsDto();
				dto.setBlogName(blogDetails.getBlogName());
				dto.setTitle(blogDetails.getTitle());
				dto.setCategory(blogDetails.getCategory());
				dto.setDescription(blogDetails.getDescription());
				dto.setCrtDate(EMPTY_STRING+blogDetails.getCrtTs());
				dto.setId(blogDetails.getId());
				try {
					dto.setImageString(new String(Base64.encodeBase64(blogDetails.getBlogImage()), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				imageDetailList.add(dto);
			}
			session.setAttribute("breakFastCreedsList", imageDetailList);
			
			
		}
		model.addAttribute(EVENING_COUNT, geteveningCount(request,response));
		model.addAttribute(MORNING_COUNT, getmorningCount(request,response));
		model.addAttribute(DINAR_COUNT, getdinarCreedsCount(request,response));
		model.addAttribute(LAUNCH_COUNT, getlaunchCount(request,response));
		model.addAttribute(BREAK_COUNT, getbreakCount(request,response));
		model.addAttribute(IMAGE_DETAIL_LIST, imageDetailList);
		
		return "blogDetailsList";
	}
	
	/**
	 * launch-creeds
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/launch-creeds", method = RequestMethod.GET)
	public String getlaunchCreeds(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		FileBucket fileModel = new FileBucket();
		List<BlogDetailsDto> imageList =null;
		model.addAttribute("fileBucket", fileModel);
		logger.info("getlaunchCreeds get method call");
		HttpSession session = request.getSession();
		imageList = (List<BlogDetailsDto>) session.getAttribute("launchCreedsList");
		List<BlogDetailsDto> imageDetailList= new ArrayList<BlogDetailsDto>();
		if(imageList!=null && imageList.size()>0){
			for (BlogDetailsDto dto : imageList) {
				imageDetailList.add(dto);
			}
			System.out.println("getting from session getlaunchCreeds");
			
		}else{
			List<BlogDetails> blogDetailsList =blogDetailsService.getByCategory("launch-creeds");
			for (BlogDetails blogDetails : blogDetailsList) {
				BlogDetailsDto dto= new BlogDetailsDto();
				dto.setBlogName(blogDetails.getBlogName());
				dto.setTitle(blogDetails.getTitle());
				dto.setCategory(blogDetails.getCategory());
				dto.setDescription(blogDetails.getDescription());
				dto.setCrtDate(EMPTY_STRING+blogDetails.getCrtTs());
				dto.setId(blogDetails.getId());
				try {
					dto.setImageString(new String(Base64.encodeBase64(blogDetails.getBlogImage()), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				imageDetailList.add(dto);
			}
			session.setAttribute("launchCreedsList", imageDetailList);
			
			
		}
		model.addAttribute(EVENING_COUNT, geteveningCount(request,response));
		model.addAttribute(MORNING_COUNT, getmorningCount(request,response));
		model.addAttribute(DINAR_COUNT, getdinarCreedsCount(request,response));
		model.addAttribute(LAUNCH_COUNT, getlaunchCount(request,response));
		model.addAttribute(BREAK_COUNT, getbreakCount(request,response));
		model.addAttribute(IMAGE_DETAIL_LIST, imageDetailList);
		
		return "blogDetailsList";
	}
	
	/**
	 * morning-creeds
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/morning-creeds", method = RequestMethod.GET)
	public String getmorningCreeds(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		FileBucket fileModel = new FileBucket();
		List<BlogDetailsDto> imageList =null;
		model.addAttribute("fileBucket", fileModel);
		logger.info("getmorningCreeds get method call");
		HttpSession session = request.getSession();
		imageList = (List<BlogDetailsDto>) session.getAttribute("morningCreedsList");
		List<BlogDetailsDto> imageDetailList= new ArrayList<BlogDetailsDto>();
		if(imageList!=null && imageList.size()>0){
			for (BlogDetailsDto dto : imageList) {
				imageDetailList.add(dto);
			}
			System.out.println("getting from session getmorningCreeds");
			
		}else{
			List<BlogDetails> blogDetailsList =blogDetailsService.getByCategory("morning-creeds");
			for (BlogDetails blogDetails : blogDetailsList) {
				BlogDetailsDto dto= new BlogDetailsDto();
				dto.setBlogName(blogDetails.getBlogName());
				dto.setTitle(blogDetails.getTitle());
				dto.setCategory(blogDetails.getCategory());
				dto.setDescription(blogDetails.getDescription());
				dto.setCrtDate(EMPTY_STRING+blogDetails.getCrtTs());
				dto.setId(blogDetails.getId());
				try {
					dto.setImageString(new String(Base64.encodeBase64(blogDetails.getBlogImage()), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				imageDetailList.add(dto);
			}
			session.setAttribute("morningCreedsList", imageDetailList);
			
			
		}
		model.addAttribute(EVENING_COUNT, geteveningCount(request,response));
		model.addAttribute(MORNING_COUNT, getmorningCount(request,response));
		model.addAttribute(DINAR_COUNT, getdinarCreedsCount(request,response));
		model.addAttribute(LAUNCH_COUNT, getlaunchCount(request,response));
		model.addAttribute(BREAK_COUNT, getbreakCount(request,response));
		model.addAttribute(IMAGE_DETAIL_LIST, imageDetailList);
		
		return "blogDetailsList";
	}
	
	/**
	 * evening-creeds
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/evening-creeds", method = RequestMethod.GET)
	public String geteveningCreeds(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		FileBucket fileModel = new FileBucket();
		List<BlogDetailsDto> imageList =null;
		model.addAttribute("fileBucket", fileModel);
		logger.info("geteveningCreeds get method call");
		HttpSession session = request.getSession();
		imageList = (List<BlogDetailsDto>) session.getAttribute("eveningCreedsList");
		List<BlogDetailsDto> imageDetailList= new ArrayList<BlogDetailsDto>();
		if(imageList!=null && imageList.size()>0){
			for (BlogDetailsDto dto : imageList) {
				imageDetailList.add(dto);
			}
			System.out.println("getting from session geteveningCreeds");
			
		}else{
			List<BlogDetails> blogDetailsList =blogDetailsService.getByCategory("evening-creeds");
			for (BlogDetails blogDetails : blogDetailsList) {
				BlogDetailsDto dto= new BlogDetailsDto();
				dto.setBlogName(blogDetails.getBlogName());
				dto.setTitle(blogDetails.getTitle());
				dto.setCategory(blogDetails.getCategory());
				dto.setDescription(blogDetails.getDescription());
				dto.setCrtDate(EMPTY_STRING+blogDetails.getCrtTs());
				dto.setId(blogDetails.getId());
				try {
					dto.setImageString(new String(Base64.encodeBase64(blogDetails.getBlogImage()), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				imageDetailList.add(dto);
			}
			session.setAttribute("eveningCreedsList", imageDetailList);
			
			
		}
		model.addAttribute(EVENING_COUNT, geteveningCount(request,response));
		model.addAttribute(MORNING_COUNT, getmorningCount(request,response));
		model.addAttribute(DINAR_COUNT, getdinarCreedsCount(request,response));
		model.addAttribute(LAUNCH_COUNT, getlaunchCount(request,response));
		model.addAttribute(BREAK_COUNT, getbreakCount(request,response));
		model.addAttribute(IMAGE_DETAIL_LIST, imageDetailList);
		
		return "blogDetailsList";
	}
	
	/**
	 * dinar-creeds
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/dinar-creeds", method = RequestMethod.GET)
	public String getdinarCreeds(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		FileBucket fileModel = new FileBucket();
		List<BlogDetailsDto> imageList =null;
		model.addAttribute("fileBucket", fileModel);
		logger.info("getdinarCreeds get method call");
		HttpSession session = request.getSession();
		imageList = (List<BlogDetailsDto>) session.getAttribute("dinarCreedsList");
		List<BlogDetailsDto> imageDetailList= new ArrayList<BlogDetailsDto>();
		if(imageList!=null && imageList.size()>0){
			for (BlogDetailsDto dto : imageList) {
				imageDetailList.add(dto);
			}
			System.out.println("getting from session getdinarCreeds");
		}else{
			List<BlogDetails> blogDetailsList =blogDetailsService.getByCategory("dinar-creeds");
			for (BlogDetails blogDetails : blogDetailsList) {
				BlogDetailsDto dto= new BlogDetailsDto();
				dto.setBlogName(blogDetails.getBlogName());
				dto.setTitle(blogDetails.getTitle());
				dto.setCategory(blogDetails.getCategory());
				dto.setDescription(blogDetails.getDescription());
				dto.setCrtDate(EMPTY_STRING+blogDetails.getCrtTs());
				dto.setId(blogDetails.getId());
				try {
					dto.setImageString(new String(Base64.encodeBase64(blogDetails.getBlogImage()), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				imageDetailList.add(dto);
			}
			session.setAttribute("dinarCreedsList", imageDetailList);
			
			
		}
		model.addAttribute(EVENING_COUNT, geteveningCount(request,response));
		model.addAttribute(MORNING_COUNT, getmorningCount(request,response));
		model.addAttribute(DINAR_COUNT, getdinarCreedsCount(request,response));
		model.addAttribute(LAUNCH_COUNT, getlaunchCount(request,response));
		model.addAttribute(BREAK_COUNT, getbreakCount(request,response));
		model.addAttribute(IMAGE_DETAIL_LIST, imageDetailList);
		
		return "blogDetailsList";
	}
	
	/**
	 * dinar-creeds
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/sweets-creeds", method = RequestMethod.GET)
	public String getSweetsCreeds(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		FileBucket fileModel = new FileBucket();
		List<BlogDetailsDto> imageList =null;
		model.addAttribute("fileBucket", fileModel);
		logger.info("getSweetsCreeds get method call");
		HttpSession session = request.getSession();
		imageList = (List<BlogDetailsDto>) session.getAttribute("sweetsCreedsList");
		List<BlogDetailsDto> imageDetailList= new ArrayList<BlogDetailsDto>();
		if(imageList!=null && imageList.size()>0){
			for (BlogDetailsDto dto : imageList) {
				imageDetailList.add(dto);
			}
			System.out.println("getting from session getSweetsCreeds");
		}else{
			List<BlogDetails> blogDetailsList =blogDetailsService.getByCategory("sweets-creeds");
			for (BlogDetails blogDetails : blogDetailsList) {
				BlogDetailsDto dto= new BlogDetailsDto();
				dto.setBlogName(blogDetails.getBlogName());
				dto.setTitle(blogDetails.getTitle());
				dto.setCategory(blogDetails.getCategory());
				dto.setDescription(blogDetails.getDescription());
				dto.setCrtDate(EMPTY_STRING+blogDetails.getCrtTs());
				dto.setId(blogDetails.getId());
				try {
					dto.setImageString(new String(Base64.encodeBase64(blogDetails.getBlogImage()), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				imageDetailList.add(dto);
			}
			session.setAttribute("sweetsCreedsList", imageDetailList);
			
			
		}
		model.addAttribute(EVENING_COUNT, geteveningCount(request,response));
		model.addAttribute(MORNING_COUNT, getmorningCount(request,response));
		model.addAttribute(DINAR_COUNT, getdinarCreedsCount(request,response));
		model.addAttribute(LAUNCH_COUNT, getlaunchCount(request,response));
		model.addAttribute(BREAK_COUNT, getbreakCount(request,response));
		model.addAttribute(IMAGE_DETAIL_LIST, imageDetailList);
		
		return "blogDetailsList";
	}
	
	
	
	/**
	 * dinar-creeds
	 */
	@RequestMapping(value="/dinarCount", method = RequestMethod.GET)
	public Integer getdinarCreedsCount(HttpServletRequest request, HttpServletResponse response) {
		Integer count=0;
		count =blogDetailsService.getByCategoryCount("dinar-creeds");
		return count;
		
	}
	/**
	 * breakCount
	 */
	@RequestMapping(value="/breakCount", method = RequestMethod.GET)
	public Integer getbreakCount(HttpServletRequest request, HttpServletResponse response) {
		Integer count=0;
		count =blogDetailsService.getByCategoryCount("breakFast-creeds");
		
		return count;
		
	}
	/**
	 * launchCount
	 */
	@RequestMapping(value="/launchCount", method = RequestMethod.GET)
	public Integer getlaunchCount(HttpServletRequest request, HttpServletResponse response) {
		Integer count=0;
		
		count =blogDetailsService.getByCategoryCount("launch-creeds");
		return count;
		
	}
	/**
	 * eveningCount
	 */
	@RequestMapping(value="/eveningCount", method = RequestMethod.GET)
	public Integer geteveningCount(HttpServletRequest request, HttpServletResponse response) {
		Integer count=0;
		
		count =blogDetailsService.getByCategoryCount("evening-creeds");
		return count;
		
	}
	/**
	 * morningCount
	 */
	@RequestMapping(value="/morningCount", method = RequestMethod.GET)
	public Integer getmorningCount(HttpServletRequest request, HttpServletResponse response) {
		Integer count=0;
		count =blogDetailsService.getByCategoryCount("morning-creeds");
		
		return count;
		
	}
	
	/**
	 * morningCount
	 */
	@RequestMapping(value="/sweetsCount", method = RequestMethod.GET)
	public Integer getSweetsCount(HttpServletRequest request, HttpServletResponse response) {
		Integer count=0;
		count =blogDetailsService.getByCategoryCount("sweets-creeds");
		
		return count;
		
	}
	
}
