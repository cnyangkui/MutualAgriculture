package com.geowind.hunong.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geowind.hunong.entity.MachineNum;
import com.geowind.hunong.jpa.EntityManagerHelper;
import com.geowind.hunong.jpa.Machine;
import com.geowind.hunong.jpa.MachineDAO;
import com.geowind.hunong.jpa.Machineowner;
import com.geowind.hunong.jpa.MachineownerDAO;
import com.geowind.hunong.service.MachineOwnerService;
import com.geowind.hunong.service.MachineService;
import com.geowind.hunong.service.impl.MachineOwnerServiceImpl;
import com.geowind.hunong.service.impl.MachineServiceImpl;
import com.geowind.hunong.util.DBHelper;
import com.geowind.hunong.util.FileUploadUtil;
import com.google.gson.Gson;

public class BMachineServlet extends BasicServlet {

	private static final long serialVersionUID = -2248323716518493306L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String op = request.getParameter("op");
//		System.out.println(op);
		switch (op) {
		case "searchAll":
			searchAll(request, response);
			break;
		case "detail":
			detail(request, response);
			break;
		case "add":
			add(request, response);
			break;
		case "delete":
			delete(request, response);
			break;
		case "editor":
			editor(request, response);
			break;
		case "uploadImage":
			uploadImage(request, response);
			break;
		case "isExistMachine":
			isExistMachine(request, response);
			break;
		case "mapSearchAll":
			MapSearchAll(request,response);
		case "editeOne":
			editeOne(request, response);
			break;
		case "findFreeMachine":
			findFreeMachine(request, response);
			break;
		case "getMachineNum":
			getMachineNum(request,response);
			break;
		default:
			break;
		}
	}

	/**
	 * 获得农机类型统计数量
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void getMachineNum(HttpServletRequest request, HttpServletResponse response) throws IOException {

	
		MachineServiceImpl machineService = new MachineServiceImpl();
		
		List<MachineNum> machineNumList = machineService.getMachineNum();
	
		this.out(response,machineNumList);
	}

	/**
	 * 查询空闲农机
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void findFreeMachine(HttpServletRequest request, HttpServletResponse response) throws IOException {
		EntityManager entityManager = EntityManagerHelper.getEntityManager();
		entityManager.getEntityManagerFactory().getCache().evictAll(); //清空二级缓存；
		entityManager.clear(); //清空一级缓存
		
		MachineService machineService = new MachineServiceImpl();
		List<Machine> machineList = machineService.findFreeMachine();
		this.out(response, machineList);
	}

	/**
	 * 修改单个属性
	 * 
	 * @param request
	 * @param response
	 */
	private void editeOne(HttpServletRequest request, HttpServletResponse response) {
		String pk = request.getParameter("pk");
		String item = request.getParameter("item");
		String value = request.getParameter("value");
//		System.out.println(value);
		MachineDAO machineDAO = new MachineDAO();
		Machine machine = machineDAO.findById(Integer.parseInt(pk));
		if("ownerId".equals(item)) {
			MachineownerDAO machineownerDao = new MachineownerDAO();
			Machineowner machineowner = machineownerDao.findById(Integer.parseInt(value));
			machine.setMachineowner(machineowner);
		} else if("type".equals(item)) {
			machine.setType(value);
		} else if("brand".equals(item)) {
			machine.setBrand(value);
		} else if("plate".equals(item)) {
			machine.setPlate(value);
		} else if("efficiency".equals(item)) {
			machine.setEfficiency(Double.parseDouble(value));
		} else if("horsepower".equals(item)) {
			machine.setHorsepower(value);
		} else if("overdate".equals(item)) {
			try {
				machine.setOverdate(new SimpleDateFormat("yyyy-MM-dd").parse(value));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		EntityManagerHelper.beginTransaction();
		try {
			machineDAO.update(machine);
			EntityManagerHelper.commit();
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
	}
	
	private void MapSearchAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		MachineDAO machineDAO = new MachineDAO();
		List<Machine> machineList = machineDAO.findAll();
		if(machineList!=null&&machineList.size()>0){
			this.out(response, machineList);
		}else{
			this.out(response, 0);
		}
		
	}

	private void isExistMachine(HttpServletRequest request, HttpServletResponse response) throws IOException {
		MachineDAO machineDAO = new MachineDAO();
		String machineplate = request.getParameter("machineplate");
		List<Machine> mList = machineDAO.findByPlate(machineplate);
		if (mList != null && mList.size() > 0) {
			this.out(response, "1");
		} else {
			this.out(response, "0");
		}

	}

	/**
	 * 编辑农机信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void editor(HttpServletRequest request, HttpServletResponse response) throws IOException {
		MachineDAO machineDAO = new MachineDAO();
		String ownername = request.getParameter("ownername");
		String plate = request.getParameter("plate");
		String type = request.getParameter("type");
		String brand = request.getParameter("brand");
		String horsepower = request.getParameter("horsepower");
		String overdate = request.getParameter("overdate");

		Machine machine = (Machine) request.getSession().getAttribute("currentMachine");
		MachineownerDAO machineownerDAO = new MachineownerDAO();
		List<Machineowner> machineowners = machineownerDAO.findByName(ownername);
		if (machineowners != null && machineowners.size() > 0) {
			machine.setMachineowner(machineowners.get(0));
		}
		machine.setPlate(plate);
		machine.setType(type);
		machine.setBrand(brand);
		machine.setHorsepower(horsepower);
		try {
			machine.setOverdate(new SimpleDateFormat("yyyy-MM-dd").parse(overdate));
		} catch (ParseException e) {
			machine.setOverdate(null);
			e.printStackTrace();
		}
		try {
			machineDAO.update(machine);
			EntityManagerHelper.commit();
			this.out(response, "1");
		} catch (RuntimeException re) {
			this.out(response, "0");
		}
	}

	/**
	 * 上传农机图片
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void uploadImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ServletConfig servletConfig = this.getServletConfig();
		FileUploadUtil.PATH = "../HN_upload/imgupload";
		FileUploadUtil uploadUtil = new FileUploadUtil();
		Map<String, String> map = null;
		try {
			map = (Map<String, String>) uploadUtil.upload(servletConfig, request, response);
			if (map != null && map.size() > 0) {
				MachineDAO machineDAO = new MachineDAO();
				Machine machine = (Machine) request.getSession().getAttribute("currentMachine");
				machine.setPicture(map.get("uploadImg"));
				EntityManagerHelper.beginTransaction();
				machineDAO.update(machine);
				EntityManagerHelper.commit();
				response.sendRedirect("bMachineServlet?op=searchAll");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除农机
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		MachineDAO machineDAO = new MachineDAO();
		String machineId = request.getParameter("machineId");
		Machine machine = null;
		EntityManagerHelper.beginTransaction();

		try {
			machine = machineDAO.findById(Integer.parseInt(machineId));
			machine.setValid(0);
			machineDAO.update(machine);
			EntityManagerHelper.commit();
			this.out(response, "1");
		} catch (RuntimeException re) {
			this.out(response, "0");
		}
	}

	/**
	 * 添加农机信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		MachineDAO machineDAO = new MachineDAO();
		Machine machine = new Machine();
		String ownerId = request.getParameter("ownerId");
		String plate = request.getParameter("plate");
		String type = request.getParameter("type");
		String brand = request.getParameter("brand");
		double efficiency = Double.parseDouble(request.getParameter("efficiency"));
		String horsepower = request.getParameter("horsepower");
		String overdate = request.getParameter("overdate");

//		System.out.println(ownerId + " " + plate + " " + type + " " + brand + " " + horsepower + " " + overdate);

		MachineownerDAO machineownerDAO = new MachineownerDAO();
		Machineowner machineowner = machineownerDAO.findById(Integer.parseInt(ownerId));
		machine.setPlate(plate);
		machine.setType(type);
		machine.setBrand(brand);
		machine.setEfficiency(efficiency);
		machine.setHorsepower(horsepower);
		machine.setMachineowner(machineowner);
		try {
			machine.setOverdate(new SimpleDateFormat("yyyy-MM-dd").parse(overdate));
		} catch (ParseException e) {
			machine.setOverdate(null);
			e.printStackTrace();
		}

		machine.setWorkstate(0);
		machine.setState(1);
		machine.setValid(1);
		EntityManagerHelper.beginTransaction();
		try {
			machineDAO.save(machine);
			EntityManagerHelper.commit();
			request.getSession().setAttribute("currentMachine", machine);
			this.out(response, "1");
		} catch (RuntimeException re) {
			this.out(response, "0");
			re.printStackTrace();
		}

	}

	/**
	 * 农机详情
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void detail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		EntityManager entityManager = EntityManagerHelper.getEntityManager();
		entityManager.getEntityManagerFactory().getCache().evictAll(); //清空二级缓存；
		entityManager.clear(); //清空一级缓存
		MachineDAO machineDAO = new MachineDAO();
		try {
			Machine machine = machineDAO.findById(Integer.parseInt(request.getParameter("machineId")));
			request.getSession().setAttribute("currentMachine", machine);
			MachineOwnerService machineService = new MachineOwnerServiceImpl();
			int centerId = (int) request.getSession().getAttribute("currentCenterId");
			List<Machineowner> machinerOwnerList = machineService.search(centerId);
			if (machinerOwnerList != null && machinerOwnerList.size() > 0) {
				request.getSession().setAttribute("allMachinerOwner", machinerOwnerList);
			}
			response.sendRedirect("manage/editormachine.jsp");
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			// 跳转至错误界面
		}
	}

	/**
	 * 查找所有农机信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void searchAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		EntityManager entityManager = EntityManagerHelper.getEntityManager();
		entityManager.getEntityManagerFactory().getCache().evictAll(); //清空二级缓存；
		entityManager.clear(); //清空一级缓存
		MachineDAO machineDAO = new MachineDAO();
		MachineOwnerService machineService = new MachineOwnerServiceImpl();
		int centerId = (int) request.getSession().getAttribute("currentCenterId");
		List<Machineowner> machinerOwnerList = machineService.search(centerId);
		if (machinerOwnerList != null && machinerOwnerList.size() > 0) {
			request.getSession().setAttribute("allMachinerOwner", machinerOwnerList);
		}
		
		List<Machine> machineList = machineDAO.findByValid(1);
		request.getSession().removeAttribute("allMachine");
		if (machineList != null && machineList.size() > 0) {
			request.getSession().setAttribute("allMachine", machineList);
			response.sendRedirect("manage/machine.jsp");
		} else {
			// 跳转至错误页面

		}
	}
}
