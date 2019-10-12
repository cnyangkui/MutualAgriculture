package com.geowind.hunong.entity;

import com.geowind.hunong.jpa.Consult;
import com.google.gson.annotations.Expose;

public class SimConsult {

	@Expose
	private Integer cid;
	@Expose
	private String username;
	@Expose
	private String ccontent;
	@Expose
	private String ctime;
	@Expose
	private String acontent;
	@Expose
	private String atime;
	@Expose
	private Integer status;
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	public String getAcontent() {
		return acontent;
	}
	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}
	public String getAtime() {
		return atime;
	}
	public void setAtime(String atime) {
		this.atime = atime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "SimConsult [cid=" + cid + ", username=" + username
				+ ", ccontent=" + ccontent + ", ctime=" + ctime + ", acontent="
				+ acontent + ", atime=" + atime + ", status=" + status + "]";
	}
	
	public SimConsult fromConsult(Consult consult) {
		SimConsult simConsult = new SimConsult();
		simConsult.setCid(consult.getCid());
		simConsult.setUsername(consult.getUser().getUsername());
		simConsult.setCcontent(consult.getCcontent());
		simConsult.setCtime(consult.getCtime());
		simConsult.setAcontent(consult.getAcontent());
		simConsult.setAtime(consult.getAtime());
		simConsult.setStatus(consult.getStatus());
		return simConsult;
	}
	
	
}
