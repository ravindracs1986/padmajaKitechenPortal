package com.padmaja.kitchen.persist.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.padmaja.kitchen.core.AbstractEntity;

/**
 * CREATE TABLE padmaja_kitchen.blog_details (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blog_name` varchar(45) DEFAULT NULL,
  `blog_image` longblob,
  `CRT_TS` timestamp NULL DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `paragraphOne` varchar(255) DEFAULT NULL,
  `paragraphTwo` varchar(255) DEFAULT NULL,
  `imageOneUrl` varchar(100) DEFAULT NULL,
  `paragraphThree` varchar(255) DEFAULT NULL,
  `imageTwoUrl` varchar(105) DEFAULT NULL,
  `paragraphFour` varchar(255) DEFAULT NULL,
  `paragraphFive` varchar(255) DEFAULT NULL,
  `paragraphSix` varchar(255) DEFAULT NULL,
  `youTubeVideoTitle` varchar(100) DEFAULT NULL,
  `youTubeVideoUrl` varchar(100) DEFAULT NULL,
  `recipeCardTitle` varchar(100) DEFAULT NULL,
  `recipeCardInsideTitle` varchar(100) DEFAULT NULL,
  `ingredientsDetails` varchar(255) DEFAULT NULL,
  `instructionsDetails` varchar(255) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `description` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * @author rvkum
 *
 */

@Entity
@Table(name = "blog_details")
public class BlogDetails extends AbstractEntity implements java.io.Serializable {

	private static final long serialVersionUID = -4393320270992003990L;
	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "blog_name", nullable = false)
	private String blogName;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "paragraphOne", nullable = false)
	private String paragraphOne;

	@Column(name = "paragraphTwo", nullable = false)
	private String paragraphTwo;

	@Column(name = "imageOneUrl", nullable = false)
	private String imageOneUrl;

	@Column(name = "paragraphThree", nullable = false)
	private String paragraphThree;

	@Column(name = "imageTwoUrl", nullable = false)
	private String imageTwoUrl;

	@Column(name = "paragraphFour", nullable = false)
	private String paragraphFour;

	@Column(name = "paragraphFive", nullable = false)
	private String paragraphFive;
	
	@Column(name = "paragraphSix", nullable = false)
	private String paragraphSix;

	@Column(name = "youTubeVideoTitle")
	private String youTubeVideoTitle;

	@Column(name = "youtubeId")
	private String youtubeId;

	@Column(name = "recipeCardTitle", nullable = false)
	private String recipeCardTitle;

	@Column(name = "recipeCardInsideTitle", nullable = false)
	private String recipeCardInsideTitle;

	@Column(name = "ingredientsDetails", nullable = false)
	private String ingredientsDetails;

	@Column(name = "instructionsDetails", nullable = false)
	private String instructionsDetails;

	@Column(name = "notes", nullable = false)
	private String notes;

	@Column(name = "blog_image", nullable = false)
	private byte[] blogImage;

	@Column(name = "category", nullable = false)
	private String category;
	@Column(name = "description", nullable = false)
	private String description;
	@Column(name = "youTubeView")
	private Integer youTubeView;

	@Column(name = "youTubeLike")
	private Integer youTubeLike;
	@Column(name = "crt_ts", nullable = false, length = 50)
	private Timestamp crtTs;
	
	@Column(name = "update_ts")
	private Timestamp updateTs;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getParagraphOne() {
		return paragraphOne;
	}

	public void setParagraphOne(String paragraphOne) {
		this.paragraphOne = paragraphOne;
	}

	public String getParagraphTwo() {
		return paragraphTwo;
	}

	public void setParagraphTwo(String paragraphTwo) {
		this.paragraphTwo = paragraphTwo;
	}

	public String getImageOneUrl() {
		return imageOneUrl;
	}

	public void setImageOneUrl(String imageOneUrl) {
		this.imageOneUrl = imageOneUrl;
	}

	public String getParagraphThree() {
		return paragraphThree;
	}

	public void setParagraphThree(String paragraphThree) {
		this.paragraphThree = paragraphThree;
	}

	public String getImageTwoUrl() {
		return imageTwoUrl;
	}

	public void setImageTwoUrl(String imageTwoUrl) {
		this.imageTwoUrl = imageTwoUrl;
	}

	public String getParagraphFour() {
		return paragraphFour;
	}

	public void setParagraphFour(String paragraphFour) {
		this.paragraphFour = paragraphFour;
	}

	
	
	public String getParagraphFive() {
		return paragraphFive;
	}

	public void setParagraphFive(String paragraphFive) {
		this.paragraphFive = paragraphFive;
	}

	public String getParagraphSix() {
		return paragraphSix;
	}

	public void setParagraphSix(String paragraphSix) {
		this.paragraphSix = paragraphSix;
	}

	public String getYouTubeVideoTitle() {
		return youTubeVideoTitle;
	}

	public void setYouTubeVideoTitle(String youTubeVideoTitle) {
		this.youTubeVideoTitle = youTubeVideoTitle;
	}

	

	public String getYoutubeId() {
		return youtubeId;
	}

	public void setYoutubeId(String youtubeId) {
		this.youtubeId = youtubeId;
	}

	public String getRecipeCardTitle() {
		return recipeCardTitle;
	}

	public void setRecipeCardTitle(String recipeCardTitle) {
		this.recipeCardTitle = recipeCardTitle;
	}

	public String getRecipeCardInsideTitle() {
		return recipeCardInsideTitle;
	}

	public void setRecipeCardInsideTitle(String recipeCardInsideTitle) {
		this.recipeCardInsideTitle = recipeCardInsideTitle;
	}

	public String getIngredientsDetails() {
		return ingredientsDetails;
	}

	public void setIngredientsDetails(String ingredientsDetails) {
		this.ingredientsDetails = ingredientsDetails;
	}

	public String getInstructionsDetails() {
		return instructionsDetails;
	}

	public void setInstructionsDetails(String instructionsDetails) {
		this.instructionsDetails = instructionsDetails;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getBlogImage() {
		return blogImage;
	}

	public void setBlogImage(byte[] blogImage) {
		this.blogImage = blogImage;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	@Override
	public Timestamp getCrtTs() {

		return this.crtTs;
	}

	@Override
	public void setCrtTs(Timestamp crtTs) {
		this.crtTs = crtTs;

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

	public Timestamp getUpdateTs() {
		return updateTs;
	}

	public void setUpdateTs(Timestamp updateTs) {
		this.updateTs = updateTs;
	}

}
