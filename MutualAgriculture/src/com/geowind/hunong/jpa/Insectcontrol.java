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
 * Insectcontrol entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "insectcontrol", catalog = "mutualagriculture")
public class Insectcontrol implements java.io.Serializable {

	// Fields
	@Expose
	private Integer cid;
	@Expose
	private User user;
	@Expose
	private String descr;
	@Expose
	private String uploadImage;
	@Expose
	private String uploadtime;
	@Expose
	private String insectImage;
	@Expose
	private String info;
	@Expose
	private String harm;
	@Expose
	private String counterplan;
	@Expose
	private String solvetime;
	@Expose
	private Integer status;

	// Constructors

	/** default constructor */
	public Insectcontrol() {
	}

	/** full constructor */
	public Insectcontrol(User user, String descr, String uploadImage,
			String uploadtime, String insectImage, String info, String harm,
			String counterplan, String solvetime, Integer status) {
		this.user = user;
		this.descr = descr;
		this.uploadImage = uploadImage;
		this.uploadtime = uploadtime;
		this.insectImage = insectImage;
		this.info = info;
		this.harm = harm;
		this.counterplan = counterplan;
		this.solvetime = solvetime;
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

	@Column(name = "descr", length = 200)
	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	@Column(name = "uploadImage", length = 1000)
	public String getUploadImage() {
		return this.uploadImage;
	}

	public void setUploadImage(String uploadImage) {
		this.uploadImage = uploadImage;
	}

	@Column(name = "uploadtime", length = 45)
	public String getUploadtime() {
		return this.uploadtime;
	}

	public void setUploadtime(String uploadtime) {
		this.uploadtime = uploadtime;
	}

	@Column(name = "insectImage", length = 200)
	public String getInsectImage() {
		return this.insectImage;
	}

	public void setInsectImage(String insectImage) {
		this.insectImage = insectImage;
	}

	@Column(name = "info", length = 200)
	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Column(name = "harm", length = 200)
	public String getHarm() {
		return this.harm;
	}

	public void setHarm(String harm) {
		this.harm = harm;
	}

	@Column(name = "counterplan", length = 200)
	public String getCounterplan() {
		return this.counterplan;
	}

	public void setCounterplan(String counterplan) {
		this.counterplan = counterplan;
	}

	@Column(name = "solvetime", length = 45)
	public String getSolvetime() {
		return this.solvetime;
	}

	public void setSolvetime(String solvetime) {
		this.solvetime = solvetime;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}