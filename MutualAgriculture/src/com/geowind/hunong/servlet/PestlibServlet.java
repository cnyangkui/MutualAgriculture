package com.geowind.hunong.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geowind.hunong.jpa.Pestlib;
import com.geowind.hunong.jpa.PestlibDAO;

public class PestlibServlet extends BasicServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String op = request.getParameter("op");
		
		switch (op) {
		case "searchAll":
			searchAll(request, response);
			break;
		case "findPest":
			findPest(request, response);
			break;
		default:
			break;
		}
	}

	/**
	 * 查找昆虫名或科目
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void findPest(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PestlibDAO pestlibDAO = new PestlibDAO();
		String content = request.getParameter("content");
		List<Pestlib> pests = pestlibDAO.findByPestname(content);
		
		if(pests == null || pests.size()==0) {
			pests = pestlibDAO.findByBranch(content);
		}
//		System.out.println(pests);
		request.getSession().setAttribute("pestlib", pests);
		this.out(response, "1");
	}

	/**
	 * 查询所有
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void searchAll(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PestlibDAO pestlibDAO = new PestlibDAO();
		List<Pestlib> pests = pestlibDAO.findAll();
		
		request.getSession().setAttribute("pestlib", pests);
		
		response.sendRedirect("manage/pestlib.jsp");
	}
}
