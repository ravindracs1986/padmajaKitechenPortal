package com.padmaja.kitchen.persist.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.padmaja.kitchen.core.GenericRepository;
import com.padmaja.kitchen.persist.entity.VideoDetails;




@Repository
@RepositoryDefinition(domainClass=VideoDetails.class, idClass=Integer.class)
@Scope("prototype")
@Qualifier("homeVideoRepo")
public interface HomeVideoRepo extends GenericRepository<VideoDetails> {

	@Query("select usr from VideoDetails usr where usr.videoCategory = :videoCategory")
	public List<VideoDetails> findbycategory(@Param("videoCategory") String videoCategory);
	/*
	@Modifying
	@Query("update UserProfile u set u.status =:status WHERE u.email = :email")
	public int updateAuthentication(@Param("status") String status,@Param("email") String email);*/

}
