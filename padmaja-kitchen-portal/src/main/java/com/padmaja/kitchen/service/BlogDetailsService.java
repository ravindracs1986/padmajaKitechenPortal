package com.padmaja.kitchen.service;

import java.sql.Timestamp;
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
	public int updateBlogDetails(int viewCount,int likeCount,String imageUrl,Timestamp updateTs,String youtubeId){
		int reslt= blogDetailsRepo.updateBlogDetails(viewCount,likeCount,imageUrl,updateTs,youtubeId);
		return reslt;
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
	public List<BlogDetails> getPopularList(){
		List<BlogDetails> blogDetails= customBlogDetailsService.getPopularLimit(null);
		return blogDetails;
	}
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public List<BlogDetails> getRecentList(){
		List<BlogDetails> blogDetails= customBlogDetailsService.getRecentLimit(null);
		return blogDetails;
	}
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public List<BlogDetails> getNewList(){
		List<BlogDetails> blogDetails= customBlogDetailsService.getNewLimit(null);
		return blogDetails;
	}
	
	
	
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public List<BlogDetails> getPopularLimit(){
		List<BlogDetails> blogDetails= customBlogDetailsService.getPopularLimit(3);
		return blogDetails;
	}
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public List<BlogDetails> getRecentLimit(){
		List<BlogDetails> blogDetails= customBlogDetailsService.getRecentLimit(3);
		return blogDetails;
	}
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public List<BlogDetails> getNewLimit(){
		List<BlogDetails> blogDetails= customBlogDetailsService.getNewLimit(3);
		return blogDetails;
	}
	
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public List<BlogDetails> findBlogForYouTubeUpdate(int day1,int day2,int maxRecords){
		List<BlogDetails> blogDetails= customBlogDetailsService.findBlogForYouTubeUpdate(day1,day2,maxRecords);
		return blogDetails;
	}

}
