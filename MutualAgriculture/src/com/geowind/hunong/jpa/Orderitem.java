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

/**
 * Orderitem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "orderitem", catalog = "mutualagriculture")
public class Orderitem implements java.io.Serializable {

	// Fields

	private Integer itemId;
	private Resource resource;
	private Order order;
	private Integer count;
	private Double totalPrice;

	// Constructors

	/** default constructor */
	public Orderitem() {
	}

	/** minimal constructor */
	public Orderitem(Resource resource, Order order) {
		this.resource = resource;
		this.order = order;
	}

	/** full constructor */
	public Orderitem(Resource resource, Order order, Integer count,
			Double totalPrice) {
		this.resource = resource;
		this.order = order;
		this.count = count;
		this.totalPrice = totalPrice;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "itemId", unique = true, nullable = false)
	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resourceId", nullable = false)
	public Resource getResource() {
		return this.resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderId", nullable = false)
	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Column(name = "count")
	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Column(name = "totalPrice", precision = 22, scale = 0)
	public Double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

}