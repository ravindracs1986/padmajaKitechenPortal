package com.padmaja.kitchen.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.padmaja.kitchen.persist.entity.BlogDetails;
import com.padmaja.kitchen.persist.entity.VideoDetails;

@Component
@Repository
public class CustomBlogDetailsService {

	@PersistenceContext
	private EntityManager entityManager;

	public List<BlogDetails> getPopularLimit() {

		List<BlogDetails> blogDetailsList = entityManager
				.createQuery("SELECT p FROM BlogDetails p ORDER BY p.view DESC", BlogDetails.class).setMaxResults(3)
				.getResultList();

		return blogDetailsList;
	}
	
	public List<BlogDetails> getRecentLimit() {

		List<BlogDetails> blogDetailsList = entityManager
				.createQuery("SELECT p FROM BlogDetails p ORDER BY p.like DESC", BlogDetails.class).setMaxResults(3)
				.getResultList();

		return blogDetailsList;
	}
	
	public List<BlogDetails> getNewLimit() {

		List<BlogDetails> blogDetailsList = entityManager
				.createQuery("SELECT p FROM BlogDetails p ORDER BY p.crtTs DESC", BlogDetails.class).setMaxResults(3)
				.getResultList();

		return blogDetailsList;
	}

	public List<VideoDetails> findLatestVideo() {

		List<VideoDetails> blogDetailsList = entityManager
				.createQuery("SELECT p FROM VideoDetails p ORDER BY p.crtTs DESC", VideoDetails.class)
				.getResultList();

		return blogDetailsList;
	}

	public List<VideoDetails> findTopVideo() {

		List<VideoDetails> blogDetailsList = entityManager
				.createQuery("SELECT p FROM VideoDetails p ORDER BY p.like DESC", VideoDetails.class)
				.getResultList();

		return blogDetailsList;
	}

}
