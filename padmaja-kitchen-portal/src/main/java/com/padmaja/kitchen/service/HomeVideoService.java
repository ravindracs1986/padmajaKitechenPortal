package com.padmaja.kitchen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.padmaja.kitchen.core.GenericRepository;
import com.padmaja.kitchen.persist.entity.BlogDetails;
import com.padmaja.kitchen.persist.entity.VideoDetails;
import com.padmaja.kitchen.persist.repo.HomeVideoRepo;



@Service("homeVideoService")
@Scope("prototype")
@Qualifier("homeVideoService")
@Transactional
public class HomeVideoService extends com.padmaja.kitchen.core.AbstractService<VideoDetails,Integer>{

	
	@Autowired HomeVideoRepo homeVideoRepo;
	@Autowired CustomBlogDetailsService customBlogDetailsService;
	@Override
	public GenericRepository<VideoDetails> primaryDao() {
		return homeVideoRepo;
	}
	
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public List<VideoDetails> findLatestVideos(){
		List<VideoDetails> blogDetails= customBlogDetailsService.findLatestVideo();
		return blogDetails;
	}
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public List<VideoDetails> findTopVideos(){
		List<VideoDetails> blogDetails= customBlogDetailsService.findTopVideo();
		return blogDetails;
	}
	
	/*@Transactional(readOnly=false,rollbackFor=Exception.class)
	public UserProfile getUserProfile(String email){
		log.info("findbyEmail method in UserProfileService class ");
		UserProfile usr= userProfileRepo.findbyEmail(email);
		return usr;
	}*/

}
