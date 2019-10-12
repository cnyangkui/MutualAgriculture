package com.geowind.hunong.service;

import java.util.List;

import com.geowind.hunong.entity.Data;
import com.geowind.hunong.jpa.Zone;

public interface ZoneService {

	public List<Zone> search(int centerId);
	
	//获取分区面积数据
	public List<Data> getZoneArea(int centerId);

	//获取庄稼类型数据
	public List<Data> getCropType(int centerId);
}
