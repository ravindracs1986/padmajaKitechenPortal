package com.padmaja.kitchen.googleapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Thumbnails {

	@JsonProperty("default")
	private Default _default;
	@JsonProperty("medium")
	private Medium medium;
	@JsonProperty("high")
	private High high;
	@JsonProperty("standard")
	private Standard standard;
	@JsonProperty("maxres")
	private Maxres maxres;

	public Default get_default() {
		return _default;
	}

	public void set_default(Default _default) {
		this._default = _default;
	}

	public Medium getMedium() {
		return medium;
	}

	public void setMedium(Medium medium) {
		this.medium = medium;
	}

	public High getHigh() {
		return high;
	}

	public void setHigh(High high) {
		this.high = high;
	}

	public Standard getStandard() {
		return standard;
	}

	public void setStandard(Standard standard) {
		this.standard = standard;
	}

	public Maxres getMaxres() {
		return maxres;
	}

	public void setMaxres(Maxres maxres) {
		this.maxres = maxres;
	}

}
