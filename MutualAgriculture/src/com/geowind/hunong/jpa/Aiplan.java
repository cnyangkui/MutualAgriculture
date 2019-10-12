package com.geowind.hunong.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

/**
 * Aiplan entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "aiplan", catalog = "mutualagriculture")
public class Aiplan implements java.io.Serializable {

	// Fields
	@Expose
	private Integer aid;
	@Expose
	private String event;
	@Expose
	private String bname;
	@Expose
	private Integer mnum;
	@Expose
	private Double totalwork;
	@Expose
	private Double efficiency;
	@Expose
	private String weather;
	@Expose
	private Integer wealevel;

	// Constructors

	/** default constructor */
	public Aiplan() {
	}

	/** minimal constructor */
	public Aiplan(Integer aid) {
		this.aid = aid;
	}

	/** full constructor */
	public Aiplan(Integer aid, String event, String bname, Integer mnum,
			Double totalwork, Double efficiency, String weather,
			Integer wealevel) {
		this.aid = aid;
		this.event = event;
		this.bname = bname;
		this.mnum = mnum;
		this.totalwork = totalwork;
		this.efficiency = efficiency;
		this.weather = weather;
		this.wealevel = wealevel;
	}

	// Property accessors
	@Id
	@Column(name = "aid", unique = true, nullable = false)
	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	@Column(name = "event", length = 45)
	public String getEvent() {
		return this.event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	@Column(name = "bname", length = 100)
	public String getBname() {
		return this.bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	@Column(name = "mnum")
	public Integer getMnum() {
		return this.mnum;
	}

	public void setMnum(Integer mnum) {
		this.mnum = mnum;
	}

	@Column(name = "totalwork", precision = 22, scale = 0)
	public Double getTotalwork() {
		return this.totalwork;
	}

	public void setTotalwork(Double totalwork) {
		this.totalwork = totalwork;
	}

	@Column(name = "efficiency", precision = 22, scale = 0)
	public Double getEfficiency() {
		return this.efficiency;
	}

	public void setEfficiency(Double efficiency) {
		this.efficiency = efficiency;
	}

	@Column(name = "weather", length = 45)
	public String getWeather() {
		return this.weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	@Column(name = "wealevel")
	public Integer getWealevel() {
		return this.wealevel;
	}

	public void setWealevel(Integer wealevel) {
		this.wealevel = wealevel;
	}

}