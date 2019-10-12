package com.geowind.hunong.entity;

import com.google.gson.annotations.Expose;

public class MachineNum {
	
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Expose
	private String num;
	@Expose
	private String type;

	
}
