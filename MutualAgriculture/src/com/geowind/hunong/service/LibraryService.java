package com.geowind.hunong.service;

import com.geowind.hunong.entity.Library;

/**
 * Created by Kui on 2016/7/23.
 */
public interface LibraryService {

	// 根据type获取该类型文章的id和title

	public Library getTitles(int begin);

	public Library getTitles(int category, int begin);

}
