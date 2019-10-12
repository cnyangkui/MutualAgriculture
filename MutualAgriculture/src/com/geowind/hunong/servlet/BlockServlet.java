package com.geowind.hunong.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import com.geowind.hunong.jpa.Zone;
import com.geowind.hunong.jpa.ZoneDAO;
import com.geowind.hunong.service.ZoneService;
import com.geowind.hunong.service.impl.ZoneServiceImpl;
import com.geowind.hunong.util.FileUploadUtil;

public class BlockServlet extends BasicServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String op = request.getParameter("op");
		
		switch (op) {
		case "addBlock":
			addBlock(request, response);
			break;
		case "getAllBlockData":
			getAllBlockData(request, response);
			break;
		case "detail":
			detail(request, response);
			break;
		case "delete":
			delete(request, response);
			break;
		case "editeOne":
			editeOne(request, response);
			break;
		case "findBlocksByZoneId":
			findBlocksByZoneId(request, response);
			break;
		case "uploadImage":
			uploadImage(request, response);
			break;
		case "getBlockByBid":
			getBlockByBid(request, response);
			break;
		default:
			break;
		}
	}
	
	/**
	 * 根据块编号查询块
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void getBlockByBid(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int bid = Integer.parseInt(request.getParameter("bid"));
		BlockDAO blockDAO = new BlockDAO();
		Block block = blockDAO.findById(bid);
		this.out(response, block);
	}

	/**
	 * 块图片上传
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
				BlockDAO blockDAO = new BlockDAO();
				Block block = (Block) request.getSession().getAttribute("currentBlock");
				block.setPicture(map.get("uploadImg"));
				EntityManagerHelper.beginTransaction();
				blockDAO.update(block);
				EntityManagerHelper.commit();
				response.sendRedirect("bZoneServlet?op=searchAll");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void findBlocksByZoneId(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ZoneDAO zoneDAO = new ZoneDAO();
		Zone zone = zoneDAO.findById(Integer.parseInt(request.getParameter("zoneId")));
		Set<Block> list = zone.getBlocks();
		this.out(response, list);
	}

	/**
	 * 编辑块信息
	 * @param request
	 * @param response
	 */
	private void editeOne(HttpServletRequest request, HttpServletResponse response) {
		String pk = request.getParameter("pk");
		String item = request.getParameter("item");
		String value = request.getParameter("value");
//		System.out.println(value);
		
		BlockDAO blockDAO = new BlockDAO();
		Block block = blockDAO.findById(Integer.parseInt(pk));
		if("bname".equals(item)) {
			block.setBname(value);
		} else if("zoneId".equals(item)) {
			ZoneDAO zoneDAO = new ZoneDAO();
			Zone zone = zoneDAO.findById(Integer.parseInt(value));
			block.setZone(zone);
		} else if("area".equals(item)) {
			block.setArea(Double.parseDouble(value));
		} else if("address".equals(item)) {
			block.setAddress(value);
		} else if("jingweidu".equals(item)) {
			String longitude = null;
			String latitude = null;
			if (!"".equals(value) && value != null) {
				longitude = value.split(",")[0];
				latitude = value.split(",")[1];
			}
			if (longitude != null && latitude != null) {
				block.setLatitude(Double.parseDouble(latitude));
				block.setLongitude(Double.parseDouble(longitude));
			} else {
				block.setLatitude(null);
				block.setLongitude(null);
			}
		}
		EntityManagerHelper.beginTransaction();
		try {
			blockDAO.update(block);
			EntityManagerHelper.commit();
			request.getSession().setAttribute("currentBlock", block);
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
	}

	/**
	 * 删除块
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BlockDAO blockDAO = new BlockDAO();
		String bid = request.getParameter("bid");
		Block block = null;
		EntityManagerHelper.beginTransaction();

		try {
			block = blockDAO.findById(Integer.parseInt(bid));
			block.setValid(0);
			blockDAO.update(block);
			EntityManagerHelper.commit();
			this.out(response, "1");
		} catch (RuntimeException re) {
			this.out(response, "0");
		}
	}

	/**
	 * 块详情
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void detail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		EntityManager entityManager = EntityManagerHelper.getEntityManager();
		entityManager.getEntityManagerFactory().getCache().evictAll(); //清空二级缓存；
		entityManager.clear(); //清空一级缓存
		BlockDAO blockDAO = new BlockDAO();
		try {
			Block zone = blockDAO.findById(Integer.parseInt(request.getParameter("bid")));
			request.getSession().setAttribute("currentBlock", zone);
			
			int centerId = (int) request.getSession().getAttribute("currentCenterId");
			ZoneService zoneService = new ZoneServiceImpl();
			List<Zone> zoneList = zoneService.search(centerId);
			request.getSession().setAttribute("allZone", zoneList);
			
			response.sendRedirect("manage/editorblock.jsp");
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
		}
	}


	/**
	 * 获取所有块的数据
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void getAllBlockData(HttpServletRequest request, HttpServletResponse response) throws IOException {
		EntityManager entityManager = EntityManagerHelper.getEntityManager();
		entityManager.getEntityManagerFactory().getCache().evictAll(); //清空二级缓存；
		entityManager.clear(); //清空一级缓存
		BlockDAO blockDAO = new BlockDAO();
		List<Block> list = blockDAO.findAll();
		this.out(response, list);
	}

	/**
	 * 添加块
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void addBlock(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BlockDAO blockDAO = new BlockDAO();
		String bname = request.getParameter("bname");
		String zoneId = request.getParameter("zoneId");
		double area = Double.parseDouble(request.getParameter("area"));
		String address = request.getParameter("address");
		String jingweidu = request.getParameter("jingweidu");
		String longitude = null;
		String latitude = null;
		if (!"".equals(jingweidu) && jingweidu != null) {
			longitude = jingweidu.split(",")[0];
			latitude = jingweidu.split(",")[1];
		}
		Block block = new Block();
		
		if (longitude != null && latitude != null) {
			block.setLatitude(Double.parseDouble(latitude));
			block.setLongitude(Double.parseDouble(longitude));
		} else {
			block.setLatitude(null);
			block.setLongitude(null);
		}
		
		
		block.setBname(bname);
		block.setArea(area);
		block.setAddress(address);
		
		ZoneDAO zoneDao = new ZoneDAO();
		Zone zone = zoneDao.findById(Integer.parseInt(zoneId));
		block.setZone(zone);
		block.setValid(1);
		
		EntityManagerHelper.beginTransaction();
		try {
			blockDAO.save(block);
			EntityManagerHelper.commit();
			request.getSession().setAttribute("currentBlock", block);
			this.out(response, "1");
		} catch (Exception e) {
			this.out(response, "0");
		}

	}
}
