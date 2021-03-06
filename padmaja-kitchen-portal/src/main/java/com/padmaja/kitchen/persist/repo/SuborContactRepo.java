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
import com.padmaja.kitchen.persist.entity.BlogDetails;
import com.padmaja.kitchen.persist.entity.SubsorContacts;
import com.padmaja.kitchen.persist.entity.VideoDetails;




@Repository
@RepositoryDefinition(domainClass=SubsorContacts.class, idClass=Integer.class)
@Scope("prototype")
@Qualifier("suborContactRepo")
public interface SuborContactRepo extends GenericRepository<SubsorContacts> {

	@Query("select detail from SubsorContacts detail where detail.id = :id")
	public SubsorContacts findbyId(@Param("id") Long id);
	
	@Query("select subsorContacts from SubsorContacts subsorContacts where subsorContacts.subEmail = :subEmail")
	public List<SubsorContacts> getSubsorContacts(@Param("subEmail") String subEmail);
	
	/*@Modifying
	@Query("update UserProfile u set u.status =:status WHERE u.email = :email")
	public int updateAuthentication(@Param("status") String status,@Param("email") String email);*/
	
	/*@Query("select detail from BlogDetails detail where detail.category = :category")
	public List<BlogDetails> getByCategory(@Param("category") String category);
	
	@Query("select count(*) from BlogDetails detail where detail.category = :category")
	public Integer getByCategoryCount(@Param("category") String category);*/

}
