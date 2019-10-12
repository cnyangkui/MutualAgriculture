package com.geowind.hunong.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.geowind.hunong.dao.PlanStandardDao;
import com.geowind.hunong.util.DBHelper;
import com.geowind.hunong.util.DateUtil;

public class PlanStandardDaoImpl implements PlanStandardDao {

	/**
	 * 更新计划
	 */
	@Override
	public int updatePlanStandard(int id, String begin, String end, double efficiency) {
		id = 10000+id;
		Calendar calendar = Calendar.getInstance();
		String year = String.valueOf(calendar.get(Calendar.YEAR));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date bDate = null, eDate = null;
		double maxdays = 0;
		try {
			bDate = sdf.parse(year+"-"+begin);
			eDate = sdf.parse(year+"-"+end);
			maxdays = DateUtil.daysBetween(bDate, eDate)+1;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String sql = "update planstandard set begin=?, end=?, maxdays=?, efficiency=? where pid=?";
		return DBHelper.doUpdate(sql, begin, end, maxdays, efficiency, id);
	}
	
}
