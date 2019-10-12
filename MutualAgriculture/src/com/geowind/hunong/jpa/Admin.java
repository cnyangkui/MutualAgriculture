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
import javax.persistence.UniqueConstraint;

import com.google.gson.annotations.Expose;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "admin", catalog = "mutualagriculture", uniqueConstraints = @UniqueConstraint(columnNames = "aname"))
public class Admin implements java.io.Serializable {

	// Fields
	@Expose
	private Integer aid;
	@Expose
	private Center center;
	@Expose
	private String aname;
	@Expose
	private String realname;
	@Expose
	private String pwd;
	@Expose
	private Integer status;

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** minimal constructor */
	public Admin(Center center, String aname, String realname, String pwd) {
		this.center = center;
		this.aname = aname;
		this.realname = realname;
		this.pwd = pwd;
	}

	/** full constructor */
	public Admin(Center center, String aname, String realname, String pwd,
			Integer status) {
		this.center = center;
		this.aname = aname;
		this.realname = realname;
		this.pwd = pwd;
		this.status = status;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "aid", unique = true, nullable = false)
	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "centerId", nullable = false)
	public Center getCenter() {
		return this.center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

	@Column(name = "aname", unique = true, nullable = false, length = 45)
	public String getAname() {
		return this.aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	@Column(name = "realname", nullable = false, length = 45)
	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Column(name = "pwd", nullable = false, length = 100)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}