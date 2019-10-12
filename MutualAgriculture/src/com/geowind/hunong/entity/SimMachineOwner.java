package com.geowind.hunong.entity;

import java.util.Calendar;
import java.util.Date;

import javafx.scene.chart.PieChart.Data;

import com.geowind.hunong.jpa.Machineowner;
import com.google.gson.annotations.Expose;

public class SimMachineOwner {

	@Expose
	private Integer ownerId;
	@Expose
	private String name;
	@Expose
	private String sex;
	@Expose
	private int age;
	@Expose
	private String phone;
	@Expose
	private String address;
	
	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "SimMachineOwner [ownerId=" + ownerId + ", name=" + name
				+ ", sex=" + sex + ", age=" + age + ", phone=" + phone
				+ ", address=" + address + "]";
	}
	
	public static SimMachineOwner fromMachineOwner(Machineowner machineowner) {
		if(machineowner == null) {
			return null;
		} else {
			SimMachineOwner simMachineOwner = new SimMachineOwner();
			simMachineOwner.setOwnerId(machineowner.getOwnerId());
			simMachineOwner.setName(machineowner.getName());
			simMachineOwner.setPhone(machineowner.getPhone());
			simMachineOwner.setSex(machineowner.getSex());
			simMachineOwner.setAddress(machineowner.getAddress());
			if(machineowner.getBirthday() != null) {
				Calendar c = Calendar.getInstance();
				int nowyear = c.get(Calendar.YEAR);
				c.setTime(machineowner.getBirthday());
				int thatyear = c.get(Calendar.YEAR);
				simMachineOwner.setAge(nowyear - thatyear);
			}
			return simMachineOwner;
		}
	}
	
}
