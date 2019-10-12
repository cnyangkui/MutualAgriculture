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
 * Pestlib entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pestlib", catalog = "mutualagriculture")
public class Pestlib implements java.io.Serializable {

	// Fields
	@Expose
	private Integer pestId;
	@Expose
	private String pestname;
	@Expose
	private String branch;
	@Expose
	private String info;
	@Expose
	private String method;
	@Expose
	private String pic;
	@Expose (serialize = false, deserialize = false)
	private Set<Pestquestion> pestquestions = new HashSet<Pestquestion>(0);

	// Constructors

	/** default constructor */
	public Pestlib() {
	}

	/** full constructor */
	public Pestlib(String pestname, String branch, String info, String method,
			String pic, Set<Pestquestion> pestquestions) {
		this.pestname = pestname;
		this.branch = branch;
		this.info = info;
		this.method = method;
		this.pic = pic;
		this.pestquestions = pestquestions;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "pestId", unique = true, nullable = false)
	public Integer getPestId() {
		return this.pestId;
	}

	public void setPestId(Integer pestId) {
		this.pestId = pestId;
	}

	@Column(name = "pestname", length = 45)
	public String getPestname() {
		return this.pestname;
	}

	public void setPestname(String pestname) {
		this.pestname = pestname;
	}

	@Column(name = "branch", length = 45)
	public String getBranch() {
		return this.branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Column(name = "info", length = 1000)
	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Column(name = "method", length = 1000)
	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Column(name = "pic", length = 200)
	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pestlib")
	public Set<Pestquestion> getPestquestions() {
		return this.pestquestions;
	}

	public void setPestquestions(Set<Pestquestion> pestquestions) {
		this.pestquestions = pestquestions;
	}

}