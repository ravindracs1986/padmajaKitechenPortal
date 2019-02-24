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
import com.padmaja.kitchen.persist.entity.VideoDetails;




@Repository
@RepositoryDefinition(domainClass=VideoDetails.class, idClass=Integer.class)
@Scope("prototype")
@Qualifier("homeVideoRepo")
public interface HomeVideoRepo extends GenericRepository<VideoDetails> {

	@Query("select usr from VideoDetails usr where usr.videoCategory = :videoCategory")
	public List<VideoDetails> findbycategory(@Param("videoCategory") String videoCategory);
	
	@Query("select usr from VideoDetails usr where usr.youtubeId = :youtubeId")
	public VideoDetails findVideosByYouTubeId(@Param("youtubeId") String youtubeId);
	
	@Modifying
	@Query("update VideoDetails u set u.youTubeView =:youTubeView,u.youTubeLike =:youTubeLike,u.updateTs =:updateTs WHERE u.youtubeId = :youtubeId")
	public int updateVideoDetails(@Param("youTubeView") Integer youTubeView,@Param("youTubeLike") Integer youTubeLike,
			@Param("updateTs") Timestamp updateTs,@Param("youtubeId") String youtubeId);

}
