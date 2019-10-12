
package com.geowind.hunong.dao.impl;

import java.util.List;
import java.util.Map;

import com.geowind.hunong.dao.LibraryDao;
import com.geowind.hunong.util.DBHelper;

/**
 * Created by Kui on 2016/7/23.
 */
public class LibraryDaoImpl implements LibraryDao {

	@Override
	public List<Map<String, Object>> selectTitle(int category, int begin) {
		String sql = "select * from article where category=? limit ?,15";
		return DBHelper.doQuery(sql, category, begin);
	}

	@Override
	public List<Map<String, Object>> selectTitle(int begin) {
		String sql = "select * from article limit ?,15";
		return DBHelper.doQuery(sql, begin);
	}
}