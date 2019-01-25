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

	@Column(name = "blog_image", nullable = false)
	private byte[] blogImage;

	public byte[] getBlogImage() {
		return blogImage;
	}

	public void setBlogImage(byte[] blogImage) {
		this.blogImage = blogImage;
	}

	@Column(name = "CRT_TS", nullable = false, length = 50)
	private Timestamp crtTs;

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

}
