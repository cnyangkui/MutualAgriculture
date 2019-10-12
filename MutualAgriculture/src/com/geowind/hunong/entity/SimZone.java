package com.geowind.hunong.entity;

import com.geowind.hunong.jpa.Zone;
import com.google.gson.annotations.Expose;

public class SimZone {

	@Expose 
	private Integer zoneId;
	@Expose 
	private String zonename;
	@Expose 
	private Double area;
	@Expose 
	private String type;
	@Expose 
	private String address;
	
	public Integer getZoneId() {
		return zoneId;
	}
	public void setZoneId(Integer zoneId) {
		this.zoneId = zoneId;
	}
	public String getZonename() {
		return zonename;
	}
	public void setZonename(String zonename) {
		this.zonename = zonename;
	}
	public Double getArea() {
		return area;
	}
	public void setArea(Double area) {
		this.area = area;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "SinZone [zoneId=" + zoneId + ", zonename=" + zonename
				+ ", area=" + area + ", type=" + type + ", address=" + address
				+ "]";
	}
	
	public static SimZone fromZone(Zone zone) {
		if(zone == null) {
			return null;
		} else {
			SimZone simZone = new SimZone();
			simZone.setZoneId(zone.getZoneId());
			simZone.setZonename(zone.getZonename());
			simZone.setArea(zone.getArea());
			simZone.setType(zone.getType());
			simZone.setAddress(zone.getAddress());
			return simZone;
		}
	}
}
