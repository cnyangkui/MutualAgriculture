/*package com.geowind.hunong.aiplanning;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

public class AiPlanning {
	
	private static List<Planstandard> standard = null;
	
	public static void main(String[] args) {
		new AiPlanning().initPlan();
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
		Date[] begin = new Date[7];
		Date[] end = new Date[7];
		
		//删除所有记录
		deleteFormerRecords();
		
		*//**
		 * 初始化第一片农田计划
		 *//*
		for(int i=0; i<a.length; i++) {
			Planstandard ps = standard.get(i);
			a[i] = new Aiplanning();
			a[i].setEvent(ps.getEvent());
			begin[i] = setDateByStandard(ps.getBegin());
			end[i] = setDateByStandard(ps.getEnd());
			a[i].setBegin(begin[i]);
			a[i].setEnd(end[i]);
			a[i].setMaxdays(ps.getMaxdays());
			Block block = blockDAO.findById(firstBlockId);
			a[i].setBlock(block);
			a[i].setTotalwork(ps.getTotalwork());
			a[i].setEfficiency(ps.getEfficiency());
			double days = Math.ceil(ps.getMaxdays()*0.6);
			a[i].setDays(days);
			a[i].setMnum((int)Math.ceil(ps.getTotalwork()/(ps.getEfficiency()*days)));
			//保存
			EntityManagerHelper.beginTransaction();
			try {
				aiplanningDAO.save(a[i]);
				EntityManagerHelper.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		*//**
		 * 初始化剩下的农田计划
		 *//*
		for(int j=firstBlockId+1; j<firstBlockId+getBlockNum(); j++) {
			for(int i=0; i<a.length; i++) {
				Planstandard ps = standard.get(i);
				a[i] = new Aiplanning();
				a[i].setEvent(ps.getEvent());
				begin[i] = getSpecifiedDayAfter(begin[i]);
				end[i] = getSpecifiedDayAfter(end[i]);
				a[i].setBegin(begin[i]);
				a[i].setEnd(end[i]);
				a[i].setMaxdays(ps.getMaxdays());
				Block block = blockDAO.findById(j);
				a[i].setBlock(block);
				a[i].setTotalwork(ps.getTotalwork());
				a[i].setEfficiency(ps.getEfficiency());
				double days = Math.ceil(ps.getMaxdays()*0.6);
				a[i].setDays(days);
				a[i].setMnum((int)Math.ceil(ps.getTotalwork()/(ps.getEfficiency()*days)));
				//保存
				EntityManagerHelper.beginTransaction();
				try {
					aiplanningDAO.save(a[i]);
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
	 * 指定时间的下一天
	 * @param specifiedDay
	 * @return
	 *//*
	private Date getSpecifiedDayAfter(Date specifiedDay){ 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance(); 
		c.setTime(specifiedDay); 
		int day=c.get(Calendar.DATE); 
		c.set(Calendar.DATE,day+1); 
		String dayAfter = sdf.format(c.getTime()); 
		try {
			return sdf.parse(dayAfter);
		} catch (ParseException e) {
			return null;
		}
	} 
	
}
*/