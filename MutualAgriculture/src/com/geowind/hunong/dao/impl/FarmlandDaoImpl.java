package com.geowind.hunong.dao.impl;

import java.util.List;
import java.util.Map;

import com.geowind.hunong.dao.FarmlandDao;
import com.geowind.hunong.util.DBHelper;

public class FarmlandDaoImpl implements FarmlandDao {

	@Override
	public List<Map<String, Object>> search() {
		String sql = "select * from farmland where valid = 1";
		return DBHelper.doQuery(sql);
	}

}
