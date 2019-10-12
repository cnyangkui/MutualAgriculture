package com.geowind.hunong.entity;

public class ArticleSim {
	public String id;

	public String title;

	public String url = null;
	public String imgURL = null;
	public String summary = null;

	// public String
	public ArticleSim(String id, String title) {
		this.id = id;
		this.title = title;
	}

	public ArticleSim(String id, String title, String summary, String url,String imgURL) {
		this.id = id;
		this.title = title;
		this.url = url;
		this.summary = summary;
		this.imgURL = imgURL;
	}
}
