package com.geowind.hunong.entity;

import java.util.List;

import com.google.gson.annotations.Expose;

public class FarmlandPoint {
	
	public List<Point> getPointList() {
		return pointList;
	}

	public void setPointList(List<Point> pointList) {
		this.pointList = pointList;
	}
	
	
	@Expose
	private List<Point> pointList;
	
	

}
