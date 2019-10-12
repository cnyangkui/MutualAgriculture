package com.geowind.hunong.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

/**
 * Systeminfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "systeminfo", catalog = "mutualagriculture")
public class Systeminfo implements java.io.Serializable {

	// Fields
	@Expose
	private Integer sid;
	@Expose
	private String title;
	@Expose
	private String content;

	// Constructors

	/** default constructor */
	public Systeminfo() {
	}

	/** full constructor */
	public Systeminfo(String title, String content) {
		this.title = title;
		this.content = content;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sid", unique = true, nullable = false)
	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	@Column(name = "title", length = 45)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content", length = 200)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}