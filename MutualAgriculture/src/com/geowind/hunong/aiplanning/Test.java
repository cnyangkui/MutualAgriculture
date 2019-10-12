/*package com.geowind.hunong.aiplanning;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.eclipse.persistence.jpa.jpql.parser.BetweenExpression;

import com.geowind.hunong.jpa.Aiplanning;
import com.geowind.hunong.jpa.AiplanningDAO;
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

import javafx.css.PseudoClass;

public class Test {
	
	private static List<Planstandard> standard = null;
	private static final double ABlockArea = 150;
	
	public static void main(String[] args) {
		new Test().initPlan();
	}
	
	*//**
	 * 初始化计划
	 *//*
	private void initPlan() {
		standard = getStandard();
		
		BlockDAO blockDAO = new BlockDAO();
		AiplanningDAO aiplanningDAO = new AiplanningDAO();
		int firstBlockId = getFirstBlockId();
		
		Aiplanning[] a = new Aiplanning[7];
		
		//获取总面积
		double totalArea = getTotalArea();
		
		
		
		
		//删除所有记录
		deleteFormerRecords();
		
		for(int k=0; k<standard.size(); k++) {
			int blockId = firstBlockId;
			Planstandard p1 = standard.get(k);
			int days = (int) Math.ceil(p1.getMaxdays() * 0.8);
			double daywork = totalArea / days;
			int pians = (int)Math.ceil(daywork / ABlockArea);
			
			int flag = 1;
			
			for(int j=0; j<days; j++) {
				StringBuffer sb = new StringBuffer();
				for(int i=blockId; i<blockId+pians; i++) {
					Block block = blockDAO.findById(i);
					if(block == null) {
						flag = 0;
					} else {
						sb.append(blockDAO.findById(i).getBname()+"片,");
					}
				}
				if(flag == 0) {
					break;
				}
				blockId += pians;
				
				Aiplanning ai = new Aiplanning();
				ai.setBname(sb.toString());
				ai.setEfficiency(p1.getEfficiency());
				ai.setEvent(p1.getEvent());
				ai.setTotalwork(pians * ABlockArea);
				Date begin = getSpecifiedDayAfter(setDateByStandard(p1.getBegin()), j);
				ai.setBegin(begin);
				ai.setEnd(getSpecifiedDayAfter(begin, 1));
				ai.setMnum((int)Math.ceil(ai.getTotalwork()/ai.getEfficiency()/8));
				//保存
				EntityManagerHelper.beginTransaction();
				try {
					aiplanningDAO.save(ai);
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
	
	*//**
	 * 获取标准计划
	 * @return
	 *//*
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
	
	*//**
	 * 获取片数量
	 * @return
	 *//*
	private int getBlockNum() {
		BlockDAO blockDAO = new BlockDAO();
		return blockDAO.findAll().size();
	}
	
	private int getFirstBlockId() {
		BlockDAO blockDAO = new BlockDAO();
		return blockDAO.findAll().get(0).getBid();
	}
	
	*//**
	 * 指定时间的后几天
	 * @param specifiedDay
	 * @return
	 *//*
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
*/