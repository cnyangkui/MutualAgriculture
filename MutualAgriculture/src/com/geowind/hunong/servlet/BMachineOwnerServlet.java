package com.geowind.hunong.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geowind.hunong.entity.SimMachineOwner;
import com.geowind.hunong.jpa.Center;
import com.geowind.hunong.jpa.EntityManagerHelper;
import com.geowind.hunong.jpa.Machine;
import com.geowind.hunong.jpa.MachineDAO;
import com.geowind.hunong.jpa.Machineowner;
import com.geowind.hunong.jpa.MachineownerDAO;
import com.geowind.hunong.service.MachineOwnerService;
import com.geowind.hunong.service.impl.MachineOwnerServiceImpl;

public class BMachineOwnerServlet extends BasicServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String op = request.getParameter("op");

		switch (op) {
		case "searchAll":
			searchAll(request, response);
			break;

		// 详情
		case "detail":
			detail(request, response);
			break;
		// 修改
		case "editor":
			editor(request, response);
			break;

		// 新增
		case "add":
			add(request, response);
			break;
		// 删除
		case "delete":
			delete(request, response);
			break;
		case "isExistMachineownerByPhone":
			isExistMachineownerByPhone(request, response);
			break;
		case "mapSearchAll":
			mapSearchAll(request, response);
			break;
		case "editeOne":
			editeOne(request, response);
			break;
		case "getAllData":
			getAllData(request, response);
			break;
		default:
			break;
		}
	}
	
	/**
	 * 向前端传送所有拥有者信息
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void getAllData(HttpServletRequest request, HttpServletResponse response) throws IOException {
		MachineOwnerService machineService = new MachineOwnerServiceImpl();
		int centerId = (int) request.getSession().getAttribute("currentCenterId");
		List<Machineowner> machinerOwnerList = machineService.search(centerId);
		List<SimMachineOwner> list = new ArrayList<SimMachineOwner>();
		for(Machineowner machineowner : machinerOwnerList) {
			list.add(SimMachineOwner.fromMachineOwner(machineowner));
		}
		this.out(response, list);

	}
	
	/**
	 * 修改单个属性
	 * @param request
	 * @param response
	 */
	private void editeOne(HttpServletRequest request,
			HttpServletResponse response) {
		String pk = request.getParameter("pk");
		String item = request.getParameter("item");
		String value = request.getParameter("value");
//		System.out.println(value);
		MachineownerDAO machineownerDAO = new MachineownerDAO();
		Machineowner machineowner = machineownerDAO.findById(Integer.parseInt(pk));
		if("name".equals(item)) {
			machineowner.setName(value);
		} else if("sex".equals(item)) {
			machineowner.setSex(value);
		} else if("birthday".equals(item)) {
			try {
				machineowner.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(value));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else if("phone".equals(item)) {
			machineowner.setPhone(value);
		} else if("address".equals(item)) {
			machineowner.setAddress(value);
		}
		EntityManagerHelper.beginTransaction();
		try {
			machineownerDAO.update(machineowner);
			EntityManagerHelper.commit();
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
	}

	private void mapSearchAll(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		MachineOwnerService machineService = new MachineOwnerServiceImpl();
		int centerId = (int) request.getSession().getAttribute("currentCenterId");
		List<Machineowner> machinerOwnerList = machineService.search(centerId);
//		System.out.println(machinerOwnerList);
		this.out(response, machinerOwnerList);
	}

	/**
	 * 是否存在农机主
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void isExistMachineownerByPhone(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		MachineownerDAO machineownerDAO = new MachineownerDAO();
		List<Machineowner> machineownerList = machineownerDAO.findByPhone(request.getParameter("phone"));
		if (machineownerList != null && machineownerList.size() > 0) {
			if (machineownerList.get(0).getValid() == 1) {
				this.out(response, "{\"mark\":\"1\",\"phone\":\"" + machineownerList.get(0).getName() + "\"}");
				// this.out(response, "1");
			} else {
				// this.out(response, "{\"mark\":\"0\"}");
				this.out(response, "0");
			}
		} else {
			// this.out(response, "{\"mark\":\"0\"}");
			this.out(response, "0");
		}
	}

	/**
	 * 删除
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		MachineownerDAO machineownerDAO = new MachineownerDAO();
		String ownerId = request.getParameter("ownerId");
		Machineowner machineowner = null;
		EntityManagerHelper.beginTransaction();

		try {
			machineowner = machineownerDAO.findById(Integer.parseInt(ownerId));
			machineowner.setValid(0);
			machineownerDAO.update(machineowner);
			EntityManagerHelper.commit();
			// request.getSession().setAttribute("allMachinerOwner", list);
			this.out(response, "1");
		} catch (RuntimeException re) {
			this.out(response, "0");
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
		MachineownerDAO machineownerDAO = new MachineownerDAO();
		try {
			Machineowner machineowner = machineownerDAO.findById(Integer.parseInt(request.getParameter("ownerId")));
			request.getSession().setAttribute("currentMachineOwner", machineowner);
			response.sendRedirect("manage/editormachineowner.jsp");
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
		}

	}

	/**
	 * 搜索所有农机拥有者
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void searchAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		EntityManager entityManager = EntityManagerHelper.getEntityManager();
		entityManager.getEntityManagerFactory().getCache().evictAll(); //清空二级缓存；
		entityManager.clear(); //清空一级缓存
		MachineOwnerService machineService = new MachineOwnerServiceImpl();
		int centerId = (int) request.getSession().getAttribute("currentCenterId");
		List<Machineowner> machinerOwnerList = machineService.search(centerId);
		request.getSession().removeAttribute("allMachinerOwner");
		if (machinerOwnerList != null && machinerOwnerList.size() > 0) {
			request.getSession().setAttribute("allMachinerOwner", machinerOwnerList);
			response.sendRedirect("manage/machineowner.jsp");
		} else {
			// 跳转出错页面
		}

	}
	

	/**
	 * 添加
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// List<Machineowner> list = (List<Machineowner>)
		// request.getSession().getAttribute("allMachinerOwner");
		int centerId = (int) request.getSession().getAttribute("currentCenterId");
		MachineownerDAO machineOwnerDAOAdd = new MachineownerDAO();
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String birthday = request.getParameter("birthday");
		Machineowner machineOwner = new Machineowner();
		machineOwner.setName(name);
		machineOwner.setAddress(address);
		machineOwner.setSex(sex);
		machineOwner.setPhone(phone);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			machineOwner.setBirthday(sdf.parse(birthday));
		} catch (ParseException e1) {
			machineOwner.setBirthday(null);
		}
		Center center = new Center();
		center.setCenterId(centerId);
		machineOwner.setCenter(center);
		machineOwner.setValid(1);
		EntityManagerHelper.beginTransaction();
		try {
			machineOwnerDAOAdd.save(machineOwner);
			EntityManagerHelper.commit();
			// list.add(machineOwner);
			// request.getSession().setAttribute("allMachinerOwner", list);
			this.out(response, "1");
		} catch (Exception e) {
			this.out(response, "0");
		}

	}

	/**
	 * 修改
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void editor(HttpServletRequest request, HttpServletResponse response) throws IOException {
		MachineownerDAO machineOwnerDAO = new MachineownerDAO();
		String username = request.getParameter("username");
		String sex = request.getParameter("sex");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String birthday = request.getParameter("birthday");
		Machineowner machineOwner = (Machineowner) request.getSession().getAttribute("currentMachineOwner");
		machineOwner.setName(username);
		machineOwner.setAddress(address);
		machineOwner.setSex(sex);
		machineOwner.setPhone(phone);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			machineOwner.setBirthday(sdf.parse(birthday));
		} catch (ParseException e) {
			machineOwner.setBirthday(null);
		}
		EntityManagerHelper.beginTransaction();
		try {
			machineOwnerDAO.update(machineOwner);
			EntityManagerHelper.commit();
			/*
			 * List<Machineowner> list = (List<Machineowner>)
			 * request.getSession().getAttribute("allMachinerOwner"); int temp =
			 * -1; for(int i=0; i<list.size(); i++) {
			 * if(list.get(i).getOwnerId() == machineOwner.getOwnerId()) { temp
			 * = i; break; } } if(temp != -1) { list.remove(temp);
			 * list.add(machineOwner); }
			 * request.getSession().setAttribute("allMachinerOwner", list);
			 */
			request.getSession().setAttribute("currentMachineOwner", machineOwner);
			this.out(response, "1");
		} catch (RuntimeException re) {
			this.out(response, "0");
		}

	}

}
