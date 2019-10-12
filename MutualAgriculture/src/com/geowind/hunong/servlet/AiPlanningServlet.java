package com.geowind.hunong.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geowind.hunong.aiplanning.AiPlan;
import com.geowind.hunong.jpa.Aiplan;
import com.geowind.hunong.jpa.AiplanDAO;
import com.geowind.hunong.jpa.EntityManagerHelper;
import com.geowind.hunong.jpa.Planstandard;
import com.geowind.hunong.jpa.PlanstandardDAO;
import com.geowind.hunong.service.PlanStandardService;
import com.geowind.hunong.service.impl.PlanStandardServiceImpl;

public class AiPlanningServlet extends BasicServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String op = request.getParameter("op");
		
		switch (op) {
		case "getPlan":
			getPlan(request, response);
			break;
		case "reloadPlan":
			reloadPlan(request, response);
			break;
		case "getPlanStandard":
			getPlanStandard(request, response);
			break;
		default:
			break;
		}
	}

	/**
	 * 获取标准
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void getPlanStandard(HttpServletRequest request, HttpServletResponse response) throws IOException {
		EntityManager entityManager = EntityManagerHelper.getEntityManager();
		entityManager.getEntityManagerFactory().getCache().evictAll(); //清空二级缓存；
		entityManager.clear(); //清空一级缓存
		PlanstandardDAO planstandardDAO = new PlanstandardDAO();
		List<Planstandard> list = planstandardDAO.findAll();
		this.out(response, list);
	}

	/**
	 * 重新规划任务
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void reloadPlan(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PlanStandardService planStandardService = new PlanStandardServiceImpl();
		/*
		 * b 表示开始时间begin
		 * e 表示结束时间end
		 * x 表示效率efficiency 
		 */
		int result = 0;
		for(int i=1; i<=7; i++) {
			String bstr = request.getParameter("b"+i);
			String estr = request.getParameter("e"+i);
			String xstr = request.getParameter("x"+i);
//			System.out.println(xstr);
			result = planStandardService.updatePlanStandard(i, bstr, estr, Double.parseDouble(xstr));
		}
		if(result > 0) {
			new AiPlan().initPlan();
			this.out(response, "1");
		} else {
			this.out(response, "0");
		}
		
	}

	/**
	 * 获取任务规划
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void getPlan(HttpServletRequest request, HttpServletResponse response) throws IOException {
		AiplanDAO aiplanDAO = new AiplanDAO();
		List<Aiplan> list = aiplanDAO.findAll();
		Iterator<Aiplan> it = list.iterator();
		while(it.hasNext()){
			Aiplan ai = it.next();
		    if(ai.getBname() == null){
		        it.remove();
		    }
		}
		this.out(response, list);
	}
	
}
