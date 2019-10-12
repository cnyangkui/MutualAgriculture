package com.geowind.hunong.entity;

import com.google.gson.annotations.Expose;
public class Point {
	@Expose
	private double x; // X坐标
	@Expose
	private double y; // Y坐标
	@Expose
	private double arCos; // 与P0点的角度
	public Point(){
		
	}
	public Point(double _x,double _y){
		x = _x;y = _y;
	}
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getArCos() {
		return arCos;
	}

	public void setArCos(double arCos) {
		this.arCos = arCos;
	}
}
