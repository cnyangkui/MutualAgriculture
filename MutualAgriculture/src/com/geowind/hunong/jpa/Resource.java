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
 * Resource entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "resource", catalog = "mutualagriculture")
public class Resource implements java.io.Serializable {

	// Fields

	private Integer resourceId;
	private String type;
	private String name;
	private Double price;
	private String function;
	private Set<Orderitem> orderitems = new HashSet<Orderitem>(0);

	// Constructors

	/** default constructor */
	public Resource() {
	}

	/** full constructor */
	public Resource(String type, String name, Double price, String function,
			Set<Orderitem> orderitems) {
		this.type = type;
		this.name = name;
		this.price = price;
		this.function = function;
		this.orderitems = orderitems;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "resourceId", unique = true, nullable = false)
	public Integer getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	@Column(name = "type", length = 45)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "price", precision = 22, scale = 0)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "function", length = 200)
	public String getFunction() {
		return this.function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "resource")
	public Set<Orderitem> getOrderitems() {
		return this.orderitems;
	}

	public void setOrderitems(Set<Orderitem> orderitems) {
		this.orderitems = orderitems;
	}

}