package com.geowind.hunong.entity;

import com.google.gson.annotations.Expose;

public class Weather {
	
	
	//一天有两个天气图标数字，以下类推第一天，第二天，第三天。。。
	@Expose
	private String first1;
	@Expose
	private String first2;
	@Expose
	private String second1;
	@Expose
	private String second2;
	@Expose
	private String third1;
	@Expose
	private String third2;
	@Expose
	private String four1;
	@Expose
	private String four2;
	@Expose
	private String five1;
	@Expose
	private String five2;
	@Expose
	private String detail;

	
	public String getFirst1() {
		return first1;
	}

	public void setFirst1(String first1) {
		this.first1 = first1;
	}

	public String getFirst2() {
		return first2;
	}

	public void setFirst2(String first2) {
		this.first2 = first2;
	}

	public String getSecond1() {
		return second1;
	}

	public void setSecond1(String second1) {
		this.second1 = second1;
	}

	public String getSecond2() {
		return second2;
	}

	public void setSecond2(String second2) {
		this.second2 = second2;
	}

	public String getThird1() {
		return third1;
	}

	public void setThird1(String third1) {
		this.third1 = third1;
	}

	public String getThird2() {
		return third2;
	}

	public void setThird2(String third2) {
		this.third2 = third2;
	}

	public String getFour1() {
		return four1;
	}

	public void setFour1(String four1) {
		this.four1 = four1;
	}

	public String getFour2() {
		return four2;
	}

	public void setFour2(String four2) {
		this.four2 = four2;
	}

	public String getFive1() {
		return five1;
	}

	public void setFive1(String five1) {
		this.five1 = five1;
	}

	public String getFive2() {
		return five2;
	}

	public void setFive2(String five2) {
		this.five2 = five2;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	
	
	
}
