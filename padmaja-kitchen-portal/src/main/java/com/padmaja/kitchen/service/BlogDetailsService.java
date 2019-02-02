package com.padmaja.kitchen.service;

import java.util.List;

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
	@Autowired CustomBlogDetailsService customBlogDetailsService;
	@Override
	public GenericRepository<BlogDetails> primaryDao() {
		return blogDetailsRepo;
	}
	
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public BlogDetails getById(Long id){
		BlogDetails blogDetails= blogDetailsRepo.findbyId(id);
		return blogDetails;
	}
	
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public List<BlogDetails> getByCategory(String category){
		List<BlogDetails> blogDetails= blogDetailsRepo.getByCategory(category);
		return blogDetails;
	}
	
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public Integer getByCategoryCount(String category){
		return blogDetailsRepo.getByCategoryCount(category);
	}
	
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public List<BlogDetails> getByLimit(){
		List<BlogDetails> blogDetails= customBlogDetailsService.getByLimit();
		return blogDetails;
	}

}
