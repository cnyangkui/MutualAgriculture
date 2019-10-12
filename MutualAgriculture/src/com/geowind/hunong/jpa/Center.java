package com.geowind.hunong.jpa;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

/**
 * Center entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "center", catalog = "mutualagriculture")
public class Center implements java.io.Serializable {

	// Fields
	@Expose
	private Integer centerId;
	@Expose
	private String address;
	@Expose
	private String level;
	@Expose
	private String name;
	@Expose
	private String principal;
	@Expose
	private Integer valid;
	@Expose (serialize = false, deserialize = false)
	private Set<Admin> admins = new HashSet<Admin>(0);
	@Expose (serialize = false, deserialize = false)
	private Set<Zone> zones = new HashSet<Zone>(0);
	@Expose (serialize = false, deserialize = false)
	private Set<Machineowner> machineowners = new HashSet<Machineowner>(0);
	@Expose (serialize = false, deserialize = false)
	private Set<Planstandard> planstandards = new HashSet<Planstandard>(0);
	@Expose (serialize = false, deserialize = false)
	private Set<Task> tasks = new HashSet<Task>(0);
	@Expose (serialize = false, deserialize = false)
	private Set<User> users = new HashSet<User>(0);

	// Constructors

	/** default constructor */
	public Center() {
	}

	/** full constructor */
	public Center(String address, String level, String name, String principal,
			Integer valid, Set<Admin> admins, Set<Zone> zones,
			Set<Machineowner> machineowners, Set<Planstandard> planstandards,
			Set<Task> tasks, Set<User> users) {
		this.address = address;
		this.level = level;
		this.name = name;
		this.principal = principal;
		this.valid = valid;
		this.admins = admins;
		this.zones = zones;
		this.machineowners = machineowners;
		this.planstandards = planstandards;
		this.tasks = tasks;
		this.users = users;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "centerId", unique = true, nullable = false)
	public Integer getCenterId() {
		return this.centerId;
	}

	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
	}

	@Column(name = "address", length = 80)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "level", length = 45)
	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "principal", length = 45)
	public String getPrincipal() {
		return this.principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	@Column(name = "valid")
	public Integer getValid() {
		return this.valid;
	}

	public void setValid(Integer valid) {
		this.valid = valid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "center")
	public Set<Admin> getAdmins() {
		return this.admins;
	}

	public void setAdmins(Set<Admin> admins) {
		this.admins = admins;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "center")
	public Set<Zone> getZones() {
		return this.zones;
	}

	public void setZones(Set<Zone> zones) {
		this.zones = zones;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "center")
	public Set<Machineowner> getMachineowners() {
		return this.machineowners;
	}

	public void setMachineowners(Set<Machineowner> machineowners) {
		this.machineowners = machineowners;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "center")
	public Set<Planstandard> getPlanstandards() {
		return this.planstandards;
	}

	public void setPlanstandards(Set<Planstandard> planstandards) {
		this.planstandards = planstandards;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "center")
	public Set<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "center")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}