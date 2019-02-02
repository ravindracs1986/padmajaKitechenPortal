package com.padmaja.kitchen.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.padmaja.kitchen.persist.entity.BlogDetails;

@Component
@Repository
public class CustomBlogDetailsService {

	@PersistenceContext
    private EntityManager entityManager;
	
	public List<BlogDetails> getByLimit(){
		
		List<BlogDetails> blogDetailsList= entityManager.createQuery("SELECT p FROM BlogDetails p ORDER BY p.id DESC",
				BlogDetails.class).setMaxResults(3).getResultList();
		
		return blogDetailsList;
	}
	
}
