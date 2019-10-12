package com.geowind.hunong.dao;

import java.util.List;
import java.util.Map;

public interface ZoneDao {

	public List<Map<String, Object>> search(int centerId);

	/**
	 * 获取分区面积数据
	 * @param centerId
	 * @return
	 */
	public List<Map<String, Object>> getZoneArea(int centerId);

	/**
	 * 获取分区作物类型数据
	 * @param centerId
	 * @return
	 */
	public List<Map<String, Object>> getCropType(int centerId); 
}
