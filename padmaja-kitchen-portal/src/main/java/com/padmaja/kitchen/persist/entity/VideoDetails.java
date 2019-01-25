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
 * CREATE TABLE `padmaja_kitchen`.`video_registration` ( `id` INT NOT NULL,
 * `video_name` VARCHAR(45) NULL, `video_url` VARCHAR(45) NULL, `video_category`
 * VARCHAR(45) NULL, `youtube_id` VARCHAR(45) NULL, `crt_dt` DATE NULL, PRIMARY
 * KEY (`id`), UNIQUE INDEX `id_UNIQUE` (`id` ASC));
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

	@Override
	public Timestamp getCrtTs() {

		return this.crtTs;
	}

	@Override
	public void setCrtTs(Timestamp crtTs) {
		this.crtTs = crtTs;

	}

}
