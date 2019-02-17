package com.padmaja.kitchen.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.padmaja.kitchen.persist.entity.BlogDetails;
import com.padmaja.kitchen.persist.entity.VideoDetails;

@Component
@Repository
public class CustomBlogDetailsService {

	@PersistenceContext
	private EntityManager entityManager;

	public List<BlogDetails> getPopularLimit(Integer limit) {
		List<BlogDetails> blogDetailsList = null;
		if (limit != null) {
			blogDetailsList = entityManager
					.createQuery("SELECT p FROM BlogDetails p ORDER BY p.youTubeView DESC", BlogDetails.class)
					.setMaxResults(limit).getResultList();

		} else {
			blogDetailsList = entityManager
					.createQuery("SELECT p FROM BlogDetails p ORDER BY p.youTubeView DESC", BlogDetails.class).getResultList();
		}
		return blogDetailsList;
	}

	public List<BlogDetails> getRecentLimit(Integer limit) {
		List<BlogDetails> blogDetailsList =null;
		if(limit!=null){
		blogDetailsList = entityManager
				.createQuery("SELECT p FROM BlogDetails p ORDER BY p.youTubeLike DESC", BlogDetails.class).setMaxResults(limit)
				.getResultList();

		
		}else{
			blogDetailsList = entityManager.createQuery("SELECT p FROM BlogDetails p ORDER BY p.youTubeLike DESC", BlogDetails.class)
					.getResultList();
		}
	
		return blogDetailsList;
	}

	public List<BlogDetails> getNewLimit(Integer limit) {
		List<BlogDetails> blogDetailsList =null;
		if(limit!=null){
			blogDetailsList = entityManager
					.createQuery("SELECT p FROM BlogDetails p ORDER BY p.crtTs DESC", BlogDetails.class).setMaxResults(limit)
					.getResultList();
			
		}else{
			blogDetailsList = entityManager
					.createQuery("SELECT p FROM BlogDetails p ORDER BY p.crtTs DESC", BlogDetails.class)
					.getResultList();
			
		}
		

		return blogDetailsList;
	}

	public List<VideoDetails> findLatestVideo() {

		List<VideoDetails> blogDetailsList = entityManager
				.createQuery("SELECT p FROM VideoDetails p ORDER BY p.crtTs DESC", VideoDetails.class).getResultList();

		return blogDetailsList;
	}

	public List<VideoDetails> findTopVideo() {

		List<VideoDetails> blogDetailsList = entityManager
				.createQuery("SELECT p FROM VideoDetails p ORDER BY p.youTubeLike DESC", VideoDetails.class).getResultList();

		return blogDetailsList;
	}
	
	public List<VideoDetails> findVideoForYouTubeUpdate(int day1,int day2) {

		Query q = entityManager
				.createQuery("SELECT videos FROM VideoDetails videos where TIMESTAMPDIFF(DAY,videos.updateTs,CURRENT_TIMESTAMP)<"+day1+" and TIMESTAMPDIFF(DAY,videos.updateTs,CURRENT_TIMESTAMP)>"+day2+"");
		q.setMaxResults(10);
		@SuppressWarnings("unchecked")
		List<VideoDetails> results = (List<VideoDetails>) q.getResultList();
		return results;
		
	}
	
	public List<BlogDetails> findBlogForYouTubeUpdate(int day1,int day2) {

		Query q = entityManager
				.createQuery("SELECT blog FROM BlogDetails blog where TIMESTAMPDIFF(DAY,videos.updateTs,CURRENT_TIMESTAMP)<"+day1+" and TIMESTAMPDIFF(DAY,videos.updateTs,CURRENT_TIMESTAMP)>"+day2+"");
		@SuppressWarnings("unchecked")
		List<BlogDetails> blogDetailsList =(List<BlogDetails>) q.getResultList();
		return blogDetailsList;
	}

}
