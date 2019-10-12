package com.geowind.hunong.dao.impl;

import com.geowind.hunong.dao.AiplanningDao;
import com.geowind.hunong.util.DBHelper;

public class AiplanningDaoImpl implements AiplanningDao {

	@Override
	public int deleteAll() {
		String sql = "delete from aiplan";
		return DBHelper.doUpdate(sql);
	}

	
}
