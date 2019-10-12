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

/**
 * Order entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "order", catalog = "mutualagriculture")
public class Order implements java.io.Serializable {

	// Fields

	private String orderId;
	private Trader trader;
	private Date date;
	private Double totalPrice;
	private Set<Orderitem> orderitems = new HashSet<Orderitem>(0);

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** minimal constructor */
	public Order(String orderId, Trader trader) {
		this.orderId = orderId;
		this.trader = trader;
	}

	/** full constructor */
	public Order(String orderId, Trader trader, Date date, Double totalPrice,
			Set<Orderitem> orderitems) {
		this.orderId = orderId;
		this.trader = trader;
		this.date = date;
		this.totalPrice = totalPrice;
		this.orderitems = orderitems;
	}

	// Property accessors
	@Id
	@Column(name = "orderId", unique = true, nullable = false, length = 20)
	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "traderId", nullable = false)
	public Trader getTrader() {
		return this.trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "totalPrice", precision = 22, scale = 0)
	public Double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "order")
	public Set<Orderitem> getOrderitems() {
		return this.orderitems;
	}

	public void setOrderitems(Set<Orderitem> orderitems) {
		this.orderitems = orderitems;
	}

}