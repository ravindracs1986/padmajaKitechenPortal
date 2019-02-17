package com.padmaja.kitchen.googleapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Statistics {
	@JsonProperty("viewCount")
	private String viewCount;
	@JsonProperty("likeCount")
	private String likeCount;
	@JsonProperty("dislikeCount")
	private String dislikeCount;
	@JsonProperty("favoriteCount")
	private String favoriteCount;
	@JsonProperty("commentCount")
	private String commentCount;

	public String getViewCount() {
		return viewCount;
	}

	public void setViewCount(String viewCount) {
		this.viewCount = viewCount;
	}

	public String getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(String likeCount) {
		this.likeCount = likeCount;
	}

	public String getDislikeCount() {
		return dislikeCount;
	}

	public void setDislikeCount(String dislikeCount) {
		this.dislikeCount = dislikeCount;
	}

	public String getFavoriteCount() {
		return favoriteCount;
	}

	public void setFavoriteCount(String favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

	public String getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(String commentCount) {
		this.commentCount = commentCount;
	}

}
