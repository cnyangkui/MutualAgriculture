package com.geowind.hunong.service.impl;

import com.geowind.hunong.dao.PlanStandardDao;
import com.geowind.hunong.dao.impl.PlanStandardDaoImpl;
import com.geowind.hunong.service.PlanStandardService;

public class PlanStandardServiceImpl implements PlanStandardService {

	private PlanStandardDao planStandardDao;
	
	public PlanStandardServiceImpl() {
		planStandardDao = new PlanStandardDaoImpl();
	}
	
	@Override
	public int updatePlanStandard(int id, String begin, String end, double efficiency) {
		return planStandardDao.updatePlanStandard(id ,begin, end, efficiency);
	}

}
