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
 * Planstandard entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "planstandard", catalog = "mutualagriculture")
public class Planstandard implements java.io.Serializable {

	// Fields
	@Expose
	private Integer pid;
	@Expose
	private Center center;
	@Expose
	private String event;
	@Expose
	private String begin;
	@Expose
	private String end;
	@Expose
	private Double maxdays;
	@Expose
	private Double totalwork;
	@Expose
	private Double efficiency;

	// Constructors

	/** default constructor */
	public Planstandard() {
	}

	/** full constructor */
	public Planstandard(Center center, String event, String begin, String end,
			Double maxdays, Double totalwork, Double efficiency) {
		this.center = center;
		this.event = event;
		this.begin = begin;
		this.end = end;
		this.maxdays = maxdays;
		this.totalwork = totalwork;
		this.efficiency = efficiency;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "pid", unique = true, nullable = false)
	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cid")
	public Center getCenter() {
		return this.center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

	@Column(name = "event", length = 100)
	public String getEvent() {
		return this.event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	@Column(name = "begin", length = 45)
	public String getBegin() {
		return this.begin;
	}

	public void setBegin(String begin) {
		this.begin = begin;
	}

	@Column(name = "end", length = 45)
	public String getEnd() {
		return this.end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	@Column(name = "maxdays", precision = 22, scale = 0)
	public Double getMaxdays() {
		return this.maxdays;
	}

	public void setMaxdays(Double maxdays) {
		this.maxdays = maxdays;
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

	@Override
	public String toString() {
		return "Planstandard [pid=" + pid + ", center=" + center + ", event=" + event + ", begin=" + begin + ", end="
				+ end + ", maxdays=" + maxdays + ", totalwork=" + totalwork + ", efficiency=" + efficiency + "]";
	}

	
}