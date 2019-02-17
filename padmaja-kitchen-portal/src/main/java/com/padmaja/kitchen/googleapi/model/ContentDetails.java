package com.padmaja.kitchen.googleapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContentDetails {
	
	@JsonProperty("duration")
	private String duration;
	@JsonProperty("dimension")
	private String dimension;
	@JsonProperty("definition")
	private String definition;
	@JsonProperty("caption")
	private String caption;
	@JsonProperty("licensedContent")
	private Boolean licensedContent;
	@JsonProperty("projection")
	private String projection;
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public String getDefinition() {
		return definition;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public Boolean getLicensedContent() {
		return licensedContent;
	}
	public void setLicensedContent(Boolean licensedContent) {
		this.licensedContent = licensedContent;
	}
	public String getProjection() {
		return projection;
	}
	public void setProjection(String projection) {
		this.projection = projection;
	}
	
	

}
