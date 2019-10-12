package com.geowind.hunong.service.impl;

import com.geowind.hunong.dao.AiplanningDao;
import com.geowind.hunong.dao.impl.AiplanningDaoImpl;
import com.geowind.hunong.service.AiplanningService;

public class AiplanningServiceImpl implements AiplanningService {

	private AiplanningDao aiplanningDao;
	
	public AiplanningServiceImpl() {
		aiplanningDao = new AiplanningDaoImpl();
	}
	
	@Override
	public int deleteAll() {
		return aiplanningDao.deleteAll();
	}

}
