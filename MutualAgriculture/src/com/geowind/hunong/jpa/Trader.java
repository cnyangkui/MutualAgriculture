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

/**
 * Trader entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "trader", catalog = "mutualagriculture")
public class Trader implements java.io.Serializable {

	// Fields

	private Integer traderId;
	private String phone;
	private String name;
	private String credit;
	private String address;
	private Set<Order> orders = new HashSet<Order>(0);

	// Constructors

	/** default constructor */
	public Trader() {
	}

	/** full constructor */
	public Trader(String phone, String name, String credit, String address,
			Set<Order> orders) {
		this.phone = phone;
		this.name = name;
		this.credit = credit;
		this.address = address;
		this.orders = orders;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "traderId", unique = true, nullable = false)
	public Integer getTraderId() {
		return this.traderId;
	}

	public void setTraderId(Integer traderId) {
		this.traderId = traderId;
	}

	@Column(name = "phone", length = 45)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "credit", length = 45)
	public String getCredit() {
		return this.credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	@Column(name = "address", length = 80)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "trader")
	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

}