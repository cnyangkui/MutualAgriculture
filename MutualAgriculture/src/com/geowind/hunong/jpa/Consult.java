package com.geowind.hunong.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

/**
 * Consult entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "consult", catalog = "mutualagriculture")
public class Consult implements java.io.Serializable {

	// Fields
	@Expose
	private Integer cid;
	@Expose
	private User user;
	@Expose
	private String ccontent;
	@Expose
	private String ctime;
	@Expose
	private String acontent;
	@Expose
	private String keywords;
	@Expose
	private String atime;
	@Expose
	private Integer status;

	// Constructors

	/** default constructor */
	public Consult() {
	}

	/** full constructor */
	public Consult(User user, String ccontent, String ctime, String acontent,
			String keywords, String atime, Integer status) {
		this.user = user;
		this.ccontent = ccontent;
		this.ctime = ctime;
		this.acontent = acontent;
		this.keywords = keywords;
		this.atime = atime;
		this.status = status;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cid", unique = true, nullable = false)
	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "username")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "ccontent", length = 500)
	public String getCcontent() {
		return this.ccontent;
	}

	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}

	@Column(name = "ctime", length = 45)
	public String getCtime() {
		return this.ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	@Column(name = "acontent", length = 500)
	public String getAcontent() {
		return this.acontent;
	}

	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}

	@Column(name = "keywords", length = 100)
	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Column(name = "atime", length = 45)
	public String getAtime() {
		return this.atime;
	}

	public void setAtime(String atime) {
		this.atime = atime;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}