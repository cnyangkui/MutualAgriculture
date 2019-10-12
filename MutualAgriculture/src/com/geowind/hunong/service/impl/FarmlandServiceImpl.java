package com.geowind.hunong.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.geowind.hunong.dao.FarmlandDao;
import com.geowind.hunong.dao.impl.FarmlandDaoImpl;
import com.geowind.hunong.jpa.Block;
import com.geowind.hunong.jpa.BlockDAO;
import com.geowind.hunong.jpa.Farmland;
import com.geowind.hunong.jpa.User;
import com.geowind.hunong.jpa.UserDAO;
import com.geowind.hunong.jpa.Zone;
import com.geowind.hunong.jpa.ZoneDAO;
import com.geowind.hunong.service.FarmlandService;

public class FarmlandServiceImpl implements FarmlandService {

	private FarmlandDao farmlandDao;
	
	public FarmlandServiceImpl() {
		farmlandDao = new FarmlandDaoImpl();
	}
	
	@Override
	public List<Farmland> search() {
		List<Map<String, Object>> maps = farmlandDao.search();
		List<Farmland> list = new ArrayList<Farmland>();
		for(Map<String, Object> map : maps) {
			Farmland farmland = new Farmland();
			farmland.setFarmlandId((int)map.get("farmlandid"));
			farmland.setLongitude((double)map.get("longitude"));
			farmland.setLatitude((double)map.get("latitude"));
			farmland.setAddress((String)map.get("address"));
			farmland.setArea((double)map.get("area"));
			farmland.setPicture((String)map.get("picture"));
			UserDAO userDAO = new UserDAO();
			User user = userDAO.findById((String)map.get("username"));
			farmland.setUser(user);
			farmland.setTranstion((String)map.get("transtion"));
			farmland.setProduction((double)map.get("production"));
			BlockDAO blockDAO = new BlockDAO();
			Block block = blockDAO.findById((int)map.get("bid"));
			farmland.setBlock(block);
			farmland.setPh((String)map.get("ph"));
			farmland.setNpk((String)map.get("npk"));
			farmland.setState((int)map.get("status"));
			farmland.setValid((int)map.get("valid"));
			list.add(farmland);
		}
		return list;
	}

	
}
