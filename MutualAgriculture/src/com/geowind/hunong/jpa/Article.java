package com.geowind.hunong.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

/**
 * Article entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "article", catalog = "mutualagriculture")
public class Article implements java.io.Serializable {

	// Fields
	@Expose
	private Integer articleId;
	@Expose
	private String classification;
	@Expose
	private String title;
	@Expose
	private String list;
	@Expose
	private String summary;
	@Expose
	private String keyword;
	@Expose
	private String content;
	@Expose
	private String imgUrl;
	@Expose
	private String videoUrl;
	@Expose
	private String other;

	// Constructors

	/** default constructor */
	public Article() {
	}

	/** full constructor */
	public Article(String classification, String title, String list,
			String summary, String keyword, String content, String imgUrl,
			String videoUrl, String other) {
		this.classification = classification;
		this.title = title;
		this.list = list;
		this.summary = summary;
		this.keyword = keyword;
		this.content = content;
		this.imgUrl = imgUrl;
		this.videoUrl = videoUrl;
		this.other = other;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "articleId", unique = true, nullable = false)
	public Integer getArticleId() {
		return this.articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	@Column(name = "classification", length = 45)
	public String getClassification() {
		return this.classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	@Column(name = "title", length = 45)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "list", length = 1000)
	public String getList() {
		return this.list;
	}

	public void setList(String list) {
		this.list = list;
	}

	@Column(name = "summary", length = 500)
	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Column(name = "keyword", length = 100)
	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Column(name = "content", length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "imgUrl", length = 200)
	public String getImgUrl() {
		return this.imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Column(name = "videoUrl", length = 200)
	public String getVideoUrl() {
		return this.videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	@Column(name = "other", length = 45)
	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

}