package com.geowind.hunong.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geowind.hunong.entity.SimUser;
import com.geowind.hunong.jpa.EntityManagerHelper;
import com.geowind.hunong.jpa.User;
import com.geowind.hunong.jpa.UserDAO;
import com.geowind.hunong.service.UserService;
import com.geowind.hunong.service.impl.UserServiceImpl;

public class BUserServlet extends BasicServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String op = request.getParameter("op");
		switch (op) {
		// 查找所有
		case "searchAll":
			searchAll(request, response);
			break;
		// 编辑信息
		case "detail":
			detail(request, response);
			break;
		case "isExistUser":
			isExistUser(request, response);
		case "MapSearchFarmer":
			MapSearchFarmer(request, response);
			break;
		case "editeOne":
			editeOne(request, response);
			break;
		case "findFreeUser":
			findFreeUser(request, response);
		default:
			break;
		}
	}

	private void findFreeUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		EntityManager entityManager = EntityManagerHelper.getEntityManager();
		entityManager.getEntityManagerFactory().getCache().evictAll(); //清空二级缓存；
		entityManager.clear(); //清空一级缓存
		UserService userService = new UserServiceImpl();
		String type = request.getParameter("type");
		int centerId = (int) request.getSession().getAttribute("currentCenterId");
		if (type.equals("v_machiner")) {
			List<User> farmerList = userService.findFreeUser(centerId, type);
			List<SimUser> list = new ArrayList<SimUser>();
			for(User user : farmerList) {
				list.add(SimUser.fromUser(user));
			}
			this.out(response, list);

		} 
	}

	/**
	 * 修改单个属性
	 * 
	 * @param request
	 * @param response
	 */
	private void editeOne(HttpServletRequest request,
			HttpServletResponse response) {
		String pk = request.getParameter("pk");
		String item = request.getParameter("item");
		String value = request.getParameter("value");
//		System.out.println(value);
		UserDAO userDAO = new UserDAO();
		User user = userDAO.findById(pk);
		if ("realname".equals(item)) {
			user.setRealname(value);
		} else if ("sex".equals(item)) {
			user.setSex(value);
		} else if ("birthday".equals(item)) {
			try {
				user.setBirthday(new SimpleDateFormat("yyyy-MM-dd")
						.parse(value));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else if ("phone".equals(item)) {
			user.setPhone(value);
		} else if ("creidt".equals(item)) {
			user.setCredit(value);
		} else if ("address".equals(item)) {
			user.setAddress(value);
		}
		EntityManagerHelper.beginTransaction();
		try {
			userDAO.update(user);
			EntityManagerHelper.commit();
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
	}

	/**
	 * 地图搜索获得所有农民信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void MapSearchFarmer(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		UserDAO userDAO = new UserDAO();
		List<User> farmerList = userDAO.findByProperty("type", 0);
		if (farmerList != null && farmerList.size() > 0) {
			this.out(response, farmerList);
		} else {
			this.out(response, 0);
		}
	}

	private void isExistUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		UserDAO userDAO = new UserDAO();
		User user = userDAO.findById(request.getParameter("username"));
		if (user != null) {
			// System.out.println("{\"mark\":\"1\",\"realname\":\""+user.getRealname()+"\"}");
			// this.out(response, "1");
			if (user.getValid() == 1) {
				this.out(response,
						"{\"mark\":\"1\",\"realname\":\"" + user.getRealname()
								+ "\",\"phone\":\"" + user.getPhone() + "\"}");
			} else {
				this.out(response, "{\"mark\":\"0\"}");
			}
		} else {
			this.out(response, "{\"mark\":\"0\"}");
		}
	}

	/**
	 * 用户详情
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void detail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		EntityManager entityManager = EntityManagerHelper.getEntityManager();
		entityManager.getEntityManagerFactory().getCache().evictAll(); //清空二级缓存；
		entityManager.clear(); //清空一级缓存
		String type = request.getParameter("type");
		if (type.equals("v_farmer")) {
			UserDAO userDAO = new UserDAO();
			User currentFarmer = userDAO.findById(request
					.getParameter("username"));
			request.getSession().setAttribute("currentFarmer", currentFarmer);
			response.sendRedirect("manage/editorfarmer.jsp");
		} else if (type.equals("v_machiner")) {
			UserDAO userDAO = new UserDAO();
			User currentMachiner = userDAO.findById(request
					.getParameter("username"));
			request.getSession().setAttribute("currentMachiner",
					currentMachiner);
			response.sendRedirect("manage/editormachiner.jsp");
		}

	}

	/**
	 * 查找所有用户
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void searchAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		EntityManager entityManager = EntityManagerHelper.getEntityManager();
		entityManager.getEntityManagerFactory().getCache().evictAll(); //清空二级缓存；
		entityManager.clear(); //清空一级缓存
		UserService userService = new UserServiceImpl();
		String type = request.getParameter("type");
		int centerId = (int) request.getSession().getAttribute("currentCenterId");
		if (type.equals("v_farmer")) {

			List<User> farmerList = userService.search(centerId, type);
			request.getSession().setAttribute("allFarmer", farmerList);

			response.sendRedirect("manage/farmer.jsp");
		} else if (type.equals("v_machiner")) {

			List<User> farmerList = userService.search(centerId, type);
			request.getSession().setAttribute("allMachiner", farmerList);

			response.sendRedirect("manage/machiner.jsp");
		}

	}

}
