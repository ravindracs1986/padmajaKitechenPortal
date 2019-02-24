package com.padmaja.kitchen.persist.repo;

import java.sql.Timestamp;
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




@Repository
@RepositoryDefinition(domainClass=BlogDetails.class, idClass=Integer.class)
@Scope("prototype")
@Qualifier("blogDetailsRepo")
public interface BlogDetailsRepo extends GenericRepository<BlogDetails> {

	@Query("select detail from BlogDetails detail where detail.id = :id")
	public BlogDetails findbyId(@Param("id") Long id);
	
	@Modifying
	@Query("update BlogDetails u set u.youTubeView =:youTubeView,u.youTubeLike =:youTubeLike,u.imageOneUrl =:imageOneUrl,u.updateTs =:updateTs WHERE u.youtubeId = :youtubeId")
	public int updateBlogDetails(@Param("youTubeView") Integer youTubeView,@Param("youTubeLike") Integer youTubeLike,
			@Param("imageOneUrl") String imageOneUrl,@Param("updateTs") Timestamp updateTs,@Param("youtubeId") String youtubeId);
	
	@Query("select detail from BlogDetails detail where detail.category = :category")
	public List<BlogDetails> getByCategory(@Param("category") String category);
	
	@Query("select count(*) from BlogDetails detail where detail.category = :category")
	public Integer getByCategoryCount(@Param("category") String category);

}
