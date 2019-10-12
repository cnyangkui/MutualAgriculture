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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.google.gson.annotations.Expose;

/**
 * Zone entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "zone", catalog = "mutualagriculture", uniqueConstraints = @UniqueConstraint(columnNames = "zonename"))
public class Zone implements java.io.Serializable {

	// Fields
	@Expose
	private Integer zoneId;
	@Expose
	private Center center;
	@Expose
	private String zonename;
	@Expose
	private Double area;
	@Expose
	private String type;
	@Expose
	private String address;
	@Expose
	private Integer valid;
	@Expose (serialize = false, deserialize = false)
	private Set<Pestzone> pestzones = new HashSet<Pestzone>(0);
	@Expose (serialize = false, deserialize = false)
	private Set<Block> blocks = new HashSet<Block>(0);

	// Constructors

	/** default constructor */
	public Zone() {
	}

	/** minimal constructor */
	public Zone(Center center, String zonename) {
		this.center = center;
		this.zonename = zonename;
	}

	/** full constructor */
	public Zone(Center center, String zonename, Double area, String type,
			String address, Integer valid, Set<Pestzone> pestzones,
			Set<Block> blocks) {
		this.center = center;
		this.zonename = zonename;
		this.area = area;
		this.type = type;
		this.address = address;
		this.valid = valid;
		this.pestzones = pestzones;
		this.blocks = blocks;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "zoneId", unique = true, nullable = false)
	public Integer getZoneId() {
		return this.zoneId;
	}

	public void setZoneId(Integer zoneId) {
		this.zoneId = zoneId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "centerId", nullable = false)
	public Center getCenter() {
		return this.center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

	@Column(name = "zonename", unique = true, nullable = false, length = 45)
	public String getZonename() {
		return this.zonename;
	}

	public void setZonename(String zonename) {
		this.zonename = zonename;
	}

	@Column(name = "area", precision = 22, scale = 0)
	public Double getArea() {
		return this.area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	@Column(name = "type", length = 45)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "address", length = 200)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "valid")
	public Integer getValid() {
		return this.valid;
	}

	public void setValid(Integer valid) {
		this.valid = valid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "zone")
	public Set<Pestzone> getPestzones() {
		return this.pestzones;
	}

	public void setPestzones(Set<Pestzone> pestzones) {
		this.pestzones = pestzones;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "zone")
	public Set<Block> getBlocks() {
		return this.blocks;
	}

	public void setBlocks(Set<Block> blocks) {
		this.blocks = blocks;
	}

}