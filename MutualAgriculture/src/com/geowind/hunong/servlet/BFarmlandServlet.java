package com.geowind.hunong.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geowind.hunong.jpa.Block;
import com.geowind.hunong.jpa.BlockDAO;
import com.geowind.hunong.jpa.EntityManagerHelper;
import com.geowind.hunong.jpa.Farmland;
import com.geowind.hunong.jpa.FarmlandDAO;
import com.geowind.hunong.jpa.Machine;
import com.geowind.hunong.jpa.User;
import com.geowind.hunong.jpa.UserDAO;
import com.geowind.hunong.jpa.Zone;
import com.geowind.hunong.jpa.ZoneDAO;
import com.geowind.hunong.service.UserService;
import com.geowind.hunong.service.ZoneService;
import com.geowind.hunong.service.impl.UserServiceImpl;
import com.geowind.hunong.service.impl.ZoneServiceImpl;
import com.geowind.hunong.util.FileUploadUtil;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class BFarmlandServlet extends BasicServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String op = request.getParameter("op");

		switch (op) {
		case "searchAll":
			searchAll(request, response);
			break;
		case "detail":
			detail(request, response);
			break;
		case "editor":
			editor(request, response);
			break;
		case "delete":
			delete(request, response);
			break;
		case "add":
			add(request, response);
			break;
		case "uploadImage":
			uploadImage(request, response);
			break;
		case "getFarmlands":
			getFarmlands(request, response);
			break;
		case "findFarmland":
			findFarmland(request, response);
			break;
		case "MapSearchAll":
			MapSearchAll(request,response);
			break;
		case "editeOne":
			editeOne(request, response);
		default:
			break;
		}
	}
	
	/**
	 * 修改单个属性
	 * 
	 * @param request
	 * @param response
	 */
	private void editeOne(HttpServletRequest request, HttpServletResponse response) {
		EntityManager entityManager = EntityManagerHelper.getEntityManager();
		entityManager.getEntityManagerFactory().getCache().evictAll(); //清空二级缓存；
		entityManager.clear(); //清空一级缓存
		String pk = request.getParameter("pk");
		String item = request.getParameter("item");
		String value = request.getParameter("value");
//		System.out.println(value);
		FarmlandDAO farmlandDAO = new FarmlandDAO();
		Farmland farmland = farmlandDAO.findById(Integer.parseInt(pk));
		if ("username".equals(item)) {
			UserDAO userDAO = new UserDAO();
			User user = userDAO.findById(value);
			farmland.setUser(user);
		} else if ("bid".equals(item)) {
//			System.out.println("bid:"+value);
			BlockDAO blockDAO = new BlockDAO();
			Block block = blockDAO.findById(Integer.parseInt(value));
			farmland.setBlock(block);
		} else if ("jingweidu".equals(item)) {
			String longitude = value.split(", ")[0];
			String latitude = value.split(", ")[1];
//			System.out.println(longitude + " " + latitude);
			farmland.setLatitude(Double.parseDouble(latitude));
			farmland.setLongitude(Double.parseDouble(longitude));
		} else if ("address".equals(item)) {
			farmland.setAddress(value);
		} else if ("area".equals(item)) {
			farmland.setArea(Double.parseDouble(value));
		} else if ("ph".equals(item)) {
			farmland.setPh(value);
		} else if("npk".equals(item)) {
			farmland.setNpk(value);
		} else if("transtion".equals(item)) {
			farmland.setTranstion(value);
		} else if("bid".equals(item)) {
//			System.out.println(value);
			if("-1".equals(value)) {
				farmland.setBlock(null);
			} else {
				BlockDAO blockDAO = new BlockDAO();
				Block block = blockDAO.findById(Integer.parseInt(value));
				farmland.setBlock(block);
			}
		}
		EntityManagerHelper.beginTransaction();
		try {
			farmlandDAO.update(farmland);
			EntityManagerHelper.commit();
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
	}

	private void MapSearchAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		FarmlandDAO farmlandDAO = new FarmlandDAO();
		List<Farmland> farmlandList = farmlandDAO.findByValid(1);
		if(farmlandList!=null&&farmlandList.size()>0){
			this.out(response, farmlandList);
		}else{
			this.out(response, 0);
		}

	}

	private void findFarmland(HttpServletRequest request, HttpServletResponse response) throws IOException {
		FarmlandDAO farmlandDAO = new FarmlandDAO();
		try {
			Farmland farmland = farmlandDAO.findById(Integer.parseInt(request.getParameter("farmlandId")));
//			System.out.println(farmland);
			this.out(response, farmland);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			this.out(response, "0");
		}
	}

	private void getFarmlands(HttpServletRequest request, HttpServletResponse response) throws IOException {
		EntityManager entityManager = EntityManagerHelper.getEntityManager();
		entityManager.getEntityManagerFactory().getCache().evictAll(); //清空二级缓存；
		entityManager.clear(); //清空一级缓存
		FarmlandDAO farmlandDAO = new FarmlandDAO();
		List<Farmland> farmlandList = farmlandDAO.findByValid(1);
		this.out(response, farmlandList);
	}

	/**
	 * 农田图片上传
	 * 
	 * @param request
	 * @param response
	 */
	private void uploadImage(HttpServletRequest request, HttpServletResponse response) {
		ServletConfig servletConfig = this.getServletConfig();
		FileUploadUtil.PATH = "../HN_upload/imgupload";
		FileUploadUtil uploadUtil = new FileUploadUtil();
		Map<String, String> map = null;
		try {
			map = (Map<String, String>) uploadUtil.upload(servletConfig, request, response);
			if (map != null && map.size() > 0) {
				FarmlandDAO farmlandDAO = new FarmlandDAO();
				Farmland farmland = (Farmland) request.getSession().getAttribute("currentFarmland");
				farmland.setPicture(map.get("uploadImg"));
				EntityManagerHelper.beginTransaction();
				farmlandDAO.update(farmland);
				EntityManagerHelper.commit();
				response.sendRedirect("bFarmlandServlet?op=searchAll");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 添加农田
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {

		FarmlandDAO farmlandDAO = new FarmlandDAO();
		Farmland farmland = new Farmland();
		
		String username = request.getParameter("username");
		String bid = request.getParameter("bid");
		String jingweidu = request.getParameter("jingweidu");
		String longitude = null;
		String latitude = null;
		if (!"".equals(jingweidu) && jingweidu != null) {
			longitude = jingweidu.split(",")[0];
			latitude = jingweidu.split(",")[1];
		}
		double area = Double.parseDouble(request.getParameter("area"));
		String ph = request.getParameter("ph");
		String npk = request.getParameter("npk");
		String address = request.getParameter("address");
		String transtion = request.getParameter("transtion");
		
		UserDAO userDAO = new UserDAO();
		farmland.setUser(userDAO.findById(username));
		
		BlockDAO blockDAO = new BlockDAO();
		farmland.setBlock(blockDAO.findById(Integer.parseInt(bid)));
		
		if (longitude != null && latitude != null) {
			farmland.setLatitude(Double.parseDouble(latitude));
			farmland.setLongitude(Double.parseDouble(longitude));
		} else {
			farmland.setLatitude(null);
			farmland.setLongitude(null);
		}
		farmland.setArea(area);
		farmland.setPh(ph);
		farmland.setNpk(npk);
		farmland.setAddress(address);
		farmland.setTranstion(transtion);
		farmland.setState(1);
		farmland.setValid(1);
		EntityManagerHelper.beginTransaction();
		try {
			farmlandDAO.save(farmland);
			EntityManagerHelper.commit();
			request.getSession().setAttribute("currentFarmland", farmland);
			this.out(response, "1");
		} catch (RuntimeException re) {
			this.out(response, "0");
		}

	}

	/**
	 * 删除农田信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		FarmlandDAO farmlandDAO = new FarmlandDAO();
		String farmlandId = request.getParameter("farmlandId");
		Farmland farmland = null;
		EntityManagerHelper.beginTransaction();

		try {
			farmland = farmlandDAO.findById(Integer.parseInt(farmlandId));
			farmland.setValid(0);
			farmlandDAO.update(farmland);
			EntityManagerHelper.commit();
			this.out(response, "1");
		} catch (RuntimeException re) {
			this.out(response, "0");
		}
	}

	/**
	 * 编辑农田信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void editor(HttpServletRequest request, HttpServletResponse response) throws IOException {
		FarmlandDAO farmlandDAO = new FarmlandDAO();
		String username = request.getParameter("username");
		String bname = request.getParameter("bname");
		String lal = request.getParameter("lal");
		String longitude = null;
		String latitude = null;
		if (!"".equals(lal) && lal != null) {
			lal = lal.substring(1, lal.length() - 1);
			longitude = lal.split(",")[0];
			latitude = lal.split(",")[1];
		}
		double area = Double.parseDouble(request.getParameter("area"));
		String ph = request.getParameter("ph");
		String npk = request.getParameter("npk");
		String address = request.getParameter("address");
		String transtion = request.getParameter("transtion");
		Farmland farmland = (Farmland) request.getSession().getAttribute("currentFarmland");
		UserDAO userDAO = new UserDAO();
		farmland.setUser(userDAO.findById(username));
		BlockDAO blockDAO = new BlockDAO();
		farmland.setBlock((blockDAO.findByBname(bname)).get(0));
		if (longitude != null && latitude != null) {
			farmland.setLatitude(Double.parseDouble(latitude));
			farmland.setLongitude(Double.parseDouble(longitude));
		} else {
			farmland.setLatitude(null);
			farmland.setLongitude(null);
		}
		farmland.setArea(area);
		farmland.setPh(ph);
		farmland.setNpk(npk);
		farmland.setAddress(address);
		farmland.setTranstion(transtion);
		EntityManagerHelper.beginTransaction();
		try {
			farmlandDAO.update(farmland);
			EntityManagerHelper.commit();
			request.getSession().setAttribute("currentFarmland", farmland);
			this.out(response, "1");
		} catch (RuntimeException re) {
			this.out(response, "0");
		}

	}

	/**
	 * 查看农田详情
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void detail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		EntityManager entityManager = EntityManagerHelper.getEntityManager();
		entityManager.getEntityManagerFactory().getCache().evictAll(); //清空二级缓存；
		entityManager.clear(); //清空一级缓存
		FarmlandDAO farmlandDAO = new FarmlandDAO();
		try {
			Farmland farmland = farmlandDAO.findById(Integer.parseInt(request.getParameter("farmlandId")));
			request.getSession().setAttribute("currentFarmland", farmland);
			
			int centerId = (int) request.getSession().getAttribute("currentCenterId");
			
			UserService userService = new UserServiceImpl();
			List<User> farmerList = userService.search(centerId, "v_farmer");
			request.getSession().setAttribute("allFarmer", farmerList);
			
			ZoneService zoneService = new ZoneServiceImpl();
			List<Zone> zoneList = zoneService.search(centerId);
			request.getSession().setAttribute("allZone", zoneList);
			
			response.sendRedirect("manage/editorfarmland.jsp");
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			// 跳转至错误界面
		}
	}

	/**
	 * 查找所有农田信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException 
	 */
	private void searchAll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		EntityManager entityManager = EntityManagerHelper.getEntityManager();
		entityManager.getEntityManagerFactory().getCache().evictAll(); //清空二级缓存；
		entityManager.clear(); //清空一级缓存
		FarmlandDAO farmlandDAO = new FarmlandDAO();
		List<Farmland> farmlandList = farmlandDAO.findByValid(1);
		request.getSession().setAttribute("allFarmland", farmlandList);
		
		int centerId = (int) request.getSession().getAttribute("currentCenterId");
		
		UserService userService = new UserServiceImpl();
		List<User> farmerList = userService.search(centerId, "v_farmer");
		request.getSession().setAttribute("allFarmer", farmerList);
		
		ZoneService zoneService = new ZoneServiceImpl();
		List<Zone> zoneList = zoneService.search(centerId);
		request.getSession().setAttribute("allZone", zoneList);
		
		response.sendRedirect("manage/farmland.jsp");
	}
}
