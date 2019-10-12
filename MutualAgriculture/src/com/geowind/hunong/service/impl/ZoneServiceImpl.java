package com.geowind.hunong.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.geowind.hunong.dao.ZoneDao;
import com.geowind.hunong.dao.impl.ZoneDaoImpl;
import com.geowind.hunong.entity.Data;
import com.geowind.hunong.jpa.Center;
import com.geowind.hunong.jpa.CenterDAO;
import com.geowind.hunong.jpa.Zone;
import com.geowind.hunong.service.ZoneService;

public class ZoneServiceImpl implements ZoneService {

	private ZoneDao zoneDao;
	
	public ZoneServiceImpl() {
		zoneDao = new ZoneDaoImpl();
	}
	
	@Override
	public List<Zone> search(int centerId) {
		List<Map<String, Object>> maps = zoneDao.search(centerId);
		List<Zone> list = new ArrayList<Zone>();
		for(Map<String, Object> map : maps) {
			Zone zone = new Zone();
			zone.setZoneId((int)map.get("zoneid"));
			zone.setZonename((String)map.get("zonename"));
			zone.setArea((double)map.get("area"));
			zone.setType((String)map.get("type"));
			zone.setAddress((String)map.get("address"));
			CenterDAO centerDAO = new CenterDAO();
			Center center = centerDAO.findById((int)map.get("centerid"));
			zone.setCenter(center);
			zone.setValid((int)map.get("valid"));
			list.add(zone);
		}
		return list;
	}

	@Override
	public List<Data> getZoneArea(int centerId) {
		List<Map<String, Object>> maps = zoneDao.getZoneArea(centerId);
		List<Data> list = new ArrayList<Data>();
		for(Map<String, Object> map : maps) {
			Data data = new Data();
			data.setName((String)map.get("zonename"));
			data.setValue(map.get("area").toString());
			list.add(data);
		}
		return list;
	}

	@Override
	public List<Data> getCropType(int centerId) {
		List<Map<String, Object>> maps = zoneDao.getCropType(centerId);
		List<Data> list = new ArrayList<Data>();
		for(Map<String, Object> map : maps) {
			Data data = new Data();
			data.setName((String)map.get("type"));
			data.setValue(map.get("area").toString());
			list.add(data);
		}
		return list;
	}

}
