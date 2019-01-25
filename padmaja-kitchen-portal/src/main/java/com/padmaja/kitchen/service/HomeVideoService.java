package com.padmaja.kitchen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.padmaja.kitchen.core.GenericRepository;
import com.padmaja.kitchen.persist.entity.VideoDetails;
import com.padmaja.kitchen.persist.repo.HomeVideoRepo;



@Service("homeVideoService")
@Scope("prototype")
@Qualifier("homeVideoService")
@Transactional
public class HomeVideoService extends com.padmaja.kitchen.core.AbstractService<VideoDetails,Integer>{

	
	@Autowired HomeVideoRepo homeVideoRepo;
	@Override
	public GenericRepository<VideoDetails> primaryDao() {
		return homeVideoRepo;
	}
	
	/*@Transactional(readOnly=false,rollbackFor=Exception.class)
	public UserProfile getUserProfile(String email){
		log.info("findbyEmail method in UserProfileService class ");
		UserProfile usr= userProfileRepo.findbyEmail(email);
		return usr;
	}*/

}
