package com.padmaja.kitchen.persist.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "video_name")
	private String videoName;

	@Column(name = "video_url")
	private String videoUrl;

	@Column(name = "video_category")
	private String videoCategory;

	@Column(name = "youtube_id")
	private String youtubeId;

	@Column(name = "youTubeView")
	private Integer youTubeView;

	@Column(name = "youTubeLike")
	private Integer youTubeLike;
	 
	@Column(name = "crt_ts")
	private Timestamp crtTs;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Integer getYouTubeView() {
		return youTubeView;
	}

	public void setYouTubeView(Integer youTubeView) {
		this.youTubeView = youTubeView;
	}

	public Integer getYouTubeLike() {
		return youTubeLike;
	}

	public void setYouTubeLike(Integer youTubeLike) {
		this.youTubeLike = youTubeLike;
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
