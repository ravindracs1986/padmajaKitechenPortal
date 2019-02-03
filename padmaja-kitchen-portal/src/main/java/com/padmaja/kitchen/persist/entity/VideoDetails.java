package com.padmaja.kitchen.persist.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.padmaja.kitchen.core.AbstractEntity;

/**
 * 
 * CREATE TABLE padmaja_kitchen.video_registration (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `video_name` varchar(45) DEFAULT NULL,
  `video_url` varchar(45) DEFAULT NULL,
  `video_category` varchar(45) DEFAULT NULL,
  `youtube_id` varchar(45) DEFAULT NULL,
  `CRT_TS` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
 * 
 * 
 * 
 * 
 * 
 * @author rvkum
 *
 */
@Entity
@Table(name = "video_registration")
public class VideoDetails extends AbstractEntity implements java.io.Serializable {

	private static final long serialVersionUID = -4393320270992003990L;
	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "video_name", nullable = false)
	private String videoName;

	@Column(name = "video_url", nullable = false)
	private String videoUrl;

	@Column(name = "video_category", nullable = false)
	private String videoCategory;

	@Column(name = "youtube_id", nullable = false)
	private String youtubeId;

	@Column(name = "view", nullable = false)
	private Integer view;

	@Column(name = "like", nullable = false)
	private Integer like;
	
	
	
	@Column(name = "CRT_TS", nullable = false, length = 50)
	private Timestamp crtTs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getVideoCategory() {
		return videoCategory;
	}

	public void setVideoCategory(String videoCategory) {
		this.videoCategory = videoCategory;
	}

	public String getYoutubeId() {
		return youtubeId;
	}

	public void setYoutubeId(String youtubeId) {
		this.youtubeId = youtubeId;
	}

	
	public Integer getView() {
		return view;
	}

	public void setView(Integer view) {
		this.view = view;
	}

	public Integer getLike() {
		return like;
	}

	public void setLike(Integer like) {
		this.like = like;
	}

	@Override
	public Timestamp getCrtTs() {

		return this.crtTs;
	}

	@Override
	public void setCrtTs(Timestamp crtTs) {
		this.crtTs = crtTs;

	}

}
