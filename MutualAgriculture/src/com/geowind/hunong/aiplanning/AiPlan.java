package com.geowind.hunong.aiplanning;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder.In;

import com.geowind.hunong.jpa.Aiplan;
import com.geowind.hunong.jpa.AiplanDAO;
import com.geowind.hunong.jpa.Block;
import com.geowind.hunong.jpa.BlockDAO;
import com.geowind.hunong.jpa.Center;
import com.geowind.hunong.jpa.CenterDAO;
import com.geowind.hunong.jpa.EntityManagerHelper;
import com.geowind.hunong.jpa.Planstandard;
import com.geowind.hunong.jpa.PlanstandardDAO;
import com.geowind.hunong.service.AiplanningService;
import com.geowind.hunong.service.impl.AiplanningServiceImpl;
import com.geowind.hunong.util.DBHelper;
import com.sun.media.sound.SF2GlobalRegion;

public class AiPlan {

	private static List<Planstandard> standard = null;
	private static final double ABlockArea = 150;
	
	public static void main(String[] args) {
		new AiPlan().initPlan();
	}
	
	/**
	 * 初始化计划
	 */
	public void initPlan() {
		standard = getStandard();
		 
		BlockDAO blockDAO = new BlockDAO();
		AiplanDAO aiplanDAO = new AiplanDAO();
		int firstBlockId = getFirstBlockId();
		
		
		//获取总面积
		double totalArea = getTotalArea();
		
		//删除所有记录
		deleteFormerRecords();
		
		
		for(int k=0; k<standard.size(); k++) {
			Planstandard p = standard.get(k);
			
			int blockId = firstBlockId;
			int days = (int) Math.ceil(p.getMaxdays() * 0.8);
			double daywork = totalArea / days;
			int pians = (int)Math.ceil(daywork / ABlockArea);
			
			for(int i=0; i<p.getMaxdays(); i++) {
				Aiplan ai = new Aiplan();
				ai.setAid(createIdByDate(getSpecifiedDayAfter(setDateByStandard(p.getBegin()), i)));
				ai.setEvent(p.getEvent());
				StringBuffer sb = new StringBuffer();
				for(int j=blockId; j<blockId+pians; j++) {
					Block block = blockDAO.findById(j);
					if(block == null) {
						sb.append("");
					} else {
						sb.append(block.getBname()+",");
					}
				}
				ai.setBname(sb.toString());
				blockId += pians;
				ai.setEfficiency(p.getEfficiency());
				if("".equals(ai.getBname())) {
					ai.setBname(null);
					ai.setTotalwork(null);
					ai.setMnum(null);
				} else {
					ai.setTotalwork(pians * ABlockArea);
					ai.setMnum((int)Math.ceil(ai.getTotalwork()/ai.getEfficiency()/8));
				}
				
				//保存
				EntityManagerHelper.beginTransaction();
				try {
					aiplanDAO.save(ai);
					EntityManagerHelper.commit();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	private void deleteFormerRecords() {
		AiplanningService s = new AiplanningServiceImpl();
		s.deleteAll();
	}

	private Date setDateByStandard(String date) {
		int year = getYear();
		date = String.valueOf(year) + "-" + date;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
	
	private int createIdByDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return Integer.parseInt(sdf.format(date));
	}
	
	/**
	 * 获取标准计划
	 * @return
	 */
	private List<Planstandard> getStandard() {
		CenterDAO centerDAO = new CenterDAO();
		Center center = centerDAO.findById(10001);
		PlanstandardDAO planstandardDAO = new PlanstandardDAO();
		return planstandardDAO.findByProperty("center", center);
	}
	
	private int getYear() {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR); 
		return year;
	}
	
	/**
	 * 获取片数量
	 * @return
	 */
	private int getBlockNum() {
		BlockDAO blockDAO = new BlockDAO();
		return blockDAO.findAll().size();
	}
	
	private int getFirstBlockId() {
		BlockDAO blockDAO = new BlockDAO();
		return blockDAO.findAll().get(0).getBid();
	}
	
	/**
	 * 指定时间的后几天
	 * @param specifiedDay
	 * @return
	 */
	private Date getSpecifiedDayAfter(Date specifiedDay, int num){ 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance(); 
		c.setTime(specifiedDay); 
		int day=c.get(Calendar.DATE); 
		c.set(Calendar.DATE,day+num); 
		String dayAfter = sdf.format(c.getTime()); 
		try {
			return sdf.parse(dayAfter);
		} catch (ParseException e) {
			return null;
		}
	} 
	
	private double getTotalArea() {
		String sql = "select sum(area) as totalarea from block";
		List<Map<String, Object>> map = DBHelper.doQuery(sql);
		return (double) map.get(0).get("totalarea");
	}
}
