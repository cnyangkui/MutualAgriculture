package com.geowind.hunong.dao.impl;

import java.util.List;
import java.util.Map;

import com.geowind.hunong.dao.ZoneDao;
import com.geowind.hunong.util.DBHelper;

public class ZoneDaoImpl implements ZoneDao {

	@Override
	public List<Map<String, Object>> search(int centerId) {
		String sql = "select * from zone where valid = 1 and centerId=?";
		return DBHelper.doQuery(sql, centerId);
	}

	@Override
	public List<Map<String, Object>> getZoneArea(int centerId) {
		String sql = "select zonename as name, area as value from zone where valid = 1 and centerId=?";
		return DBHelper.doQuery(sql, centerId);
	}

	@Override
	public List<Map<String, Object>> getCropType(int centerId) {
		String sql = "select type, sum(area) as area from zone where valid = 1 and centerId=? group by type";
		return DBHelper.doQuery(sql, centerId);
	}

}
