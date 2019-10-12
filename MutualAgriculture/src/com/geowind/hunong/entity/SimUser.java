package com.geowind.hunong.entity;

import java.util.Date;

import javax.persistence.criteria.From;

import com.geowind.hunong.jpa.User;
import com.google.gson.annotations.Expose;

/**
 * Created by Kui on 2016/7/20.
 */
public class SimUser {

	@Expose
	private String username;
	@Expose
	private String centername;
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
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCentername() {
		return centername;
	}
	public void setCentername(String centername) {
		this.centername = centername;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public Integer getValid() {
		return valid;
	}
	public void setValid(Integer valid) {
		this.valid = valid;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
    
	public static SimUser fromUser(User user) {
		if(user == null) {
			return null;
		} else {
			SimUser simUser = new SimUser();
			simUser.setUsername(user.getUsername());
			simUser.setAddress(user.getAddress());
			simUser.setBirthday(user.getBirthday());
			simUser.setCentername(user.getCenter().getName());
			simUser.setCredit(user.getCredit());
			simUser.setPassword(user.getPassword());
			simUser.setPhone(user.getPhone());
			simUser.setPicture(user.getPicture());
			simUser.setRealname(user.getRealname());
			simUser.setSex(user.getSex());
			simUser.setStatus(user.getStatus());
			simUser.setType(user.getType());
			simUser.setValid(user.getValid());
			return simUser;
		}
	}
}
