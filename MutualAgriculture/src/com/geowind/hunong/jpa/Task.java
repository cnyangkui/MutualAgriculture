package com.geowind.hunong.jpa;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.gson.annotations.Expose;

/**
 * Task entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "task", catalog = "mutualagriculture")
public class Task implements java.io.Serializable {

	// Fields
	@Expose
	private Integer taskId;
	@Expose
	private Center center;
	@Expose
	private Block block;
	@Expose
	private User user;
	@Expose
	private Machine machine;
	@Expose
	private Integer workload;
	@Expose
	private Date publishdate;
	@Expose
	private Date workdate;
	@Expose
	private Date finishdate;
	@Expose
	private String type;
	@Expose
	private Integer finished;
	@Expose
	private String descr;

	// Constructors

	/** default constructor */
	public Task() {
	}

	/** minimal constructor */
	public Task(Block block, User user, Machine machine) {
		this.block = block;
		this.user = user;
		this.machine = machine;
	}

	/** full constructor */
	public Task(Center center, Block block, User user, Machine machine,
			Integer workload, Date publishdate, Date workdate, Date finishdate,
			String type, Integer finished, String descr) {
		this.center = center;
		this.block = block;
		this.user = user;
		this.machine = machine;
		this.workload = workload;
		this.publishdate = publishdate;
		this.workdate = workdate;
		this.finishdate = finishdate;
		this.type = type;
		this.finished = finished;
		this.descr = descr;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "taskId", unique = true, nullable = false)
	public Integer getTaskId() {
		return this.taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "centerId")
	public Center getCenter() {
		return this.center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "blockId", nullable = false)
	public Block getBlock() {
		return this.block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "username", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "machineId", nullable = false)
	public Machine getMachine() {
		return this.machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	@Column(name = "workload")
	public Integer getWorkload() {
		return this.workload;
	}

	public void setWorkload(Integer workload) {
		this.workload = workload;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "publishdate", length = 10)
	public Date getPublishdate() {
		return this.publishdate;
	}

	public void setPublishdate(Date publishdate) {
		this.publishdate = publishdate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "workdate", length = 10)
	public Date getWorkdate() {
		return this.workdate;
	}

	public void setWorkdate(Date workdate) {
		this.workdate = workdate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "finishdate", length = 10)
	public Date getFinishdate() {
		return this.finishdate;
	}

	public void setFinishdate(Date finishdate) {
		this.finishdate = finishdate;
	}

	@Column(name = "type", length = 45)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "finished")
	public Integer getFinished() {
		return this.finished;
	}

	public void setFinished(Integer finished) {
		this.finished = finished;
	}

	@Column(name = "descr", length = 1000)
	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

}