package com.padmaja.kitchen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.padmaja.kitchen.core.GenericRepository;
import com.padmaja.kitchen.persist.entity.BlogDetails;
import com.padmaja.kitchen.persist.repo.BlogDetailsRepo;



@Service("blogDetailsService")
@Scope("prototype")
@Qualifier("blogDetailsService")
@Transactional
public class BlogDetailsService extends com.padmaja.kitchen.core.AbstractService<BlogDetails,Integer>{

	
	@Autowired BlogDetailsRepo blogDetailsRepo;
	@Override
	public GenericRepository<BlogDetails> primaryDao() {
		return blogDetailsRepo;
	}
	
	/*@Transactional(readOnly=false,rollbackFor=Exception.class)
	public UserProfile getUserProfile(String email){
		log.info("findbyEmail method in UserProfileService class ");
		UserProfile usr= userProfileRepo.findbyEmail(email);
		return usr;
	}*/

}
