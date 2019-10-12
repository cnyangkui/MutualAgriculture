package com.geowind.hunong.jpa;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.gson.annotations.Expose;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "mutualagriculture")
public class User implements java.io.Serializable {

	// Fields
	@Expose
	private String username;
	@Expose
	private Center center;
	@Expose
	private String password;
	@Expose
	private String realname;
	@Expose
	private String sex;
	@Expose
	private Date birthday;
	@Expose
	private String phone;
	@Expose
	private Integer type;
	@Expose
	private String picture;
	@Expose
	private String address;
	@Expose
	private String credit;
	@Expose
	private Integer valid;
	@Expose
	private Integer status;
	@Expose (serialize = false, deserialize = false)
	private Set<Farmland> farmlands = new HashSet<Farmland>(0);
	@Expose (serialize = false, deserialize = false)
	private Set<Pestquestion> pestquestions = new HashSet<Pestquestion>(0);
	@Expose (serialize = false, deserialize = false)
	private Set<Insectcontrol> insectcontrols = new HashSet<Insectcontrol>(0);
	@Expose (serialize = false, deserialize = false)
	private Set<Task> tasks = new HashSet<Task>(0);
	@Expose (serialize = false, deserialize = false)
	private Set<Consult> consults = new HashSet<Consult>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String username, Center center, String password,
			String realname, String phone, Integer type) {
		this.username = username;
		this.center = center;
		this.password = password;
		this.realname = realname;
		this.phone = phone;
		this.type = type;
	}

	/** full constructor */
	public User(String username, Center center, String password,
			String realname, String sex, Date birthday, String phone,
			Integer type, String picture, String address, String credit,
			Integer valid, Integer status, Set<Farmland> farmlands,
			Set<Pestquestion> pestquestions, Set<Insectcontrol> insectcontrols,
			Set<Task> tasks, Set<Consult> consults) {
		this.username = username;
		this.center = center;
		this.password = password;
		this.realname = realname;
		this.sex = sex;
		this.birthday = birthday;
		this.phone = phone;
		this.type = type;
		this.picture = picture;
		this.address = address;
		this.credit = credit;
		this.valid = valid;
		this.status = status;
		this.farmlands = farmlands;
		this.pestquestions = pestquestions;
		this.insectcontrols = insectcontrols;
		this.tasks = tasks;
		this.consults = consults;
	}

	// Property accessors
	@Id
	@Column(name = "username", unique = true, nullable = false, length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "centerId", nullable = false)
	public Center getCenter() {
		return this.center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

	@Column(name = "password", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "realname", nullable = false, length = 45)
	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Column(name = "sex", length = 45)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday", length = 10)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "phone", nullable = false, length = 45)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "type", nullable = false)
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "picture", length = 200)
	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Column(name = "address", length = 200)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "credit", length = 45)
	public String getCredit() {
		return this.credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	@Column(name = "valid")
	public Integer getValid() {
		return this.valid;
	}

	public void setValid(Integer valid) {
		this.valid = valid;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Farmland> getFarmlands() {
		return this.farmlands;
	}

	public void setFarmlands(Set<Farmland> farmlands) {
		this.farmlands = farmlands;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Pestquestion> getPestquestions() {
		return this.pestquestions;
	}

	public void setPestquestions(Set<Pestquestion> pestquestions) {
		this.pestquestions = pestquestions;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Insectcontrol> getInsectcontrols() {
		return this.insectcontrols;
	}

	public void setInsectcontrols(Set<Insectcontrol> insectcontrols) {
		this.insectcontrols = insectcontrols;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Consult> getConsults() {
		return this.consults;
	}

	public void setConsults(Set<Consult> consults) {
		this.consults = consults;
	}

}