package com.geowind.hunong.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geowind.hunong.entity.SimConsult;
import com.geowind.hunong.entity.SimTask;
import com.geowind.hunong.jpa.Consult;
import com.geowind.hunong.jpa.ConsultDAO;
import com.geowind.hunong.jpa.EntityManagerHelper;
import com.geowind.hunong.util.JPushUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConsultServlet extends BasicServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String op = request.getParameter("op");
		switch (op) {
		case "consulting":
			consulting(request, response);
			break;
		case "consulted":
			consulted(request, response);
			break;
		case "answer":
			answer(request, response);
			break;
		default:
			break;
		}
	}

	/**
	 * 回答
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void answer(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int cid = Integer.parseInt(request.getParameter("cid"));
		String centent = request.getParameter("content");
		ConsultDAO consultDAO = new ConsultDAO();
		Consult consult = consultDAO.findById(cid);
		consult.setAcontent(centent);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		consult.setAtime(date);
		consult.setStatus(1);
		EntityManagerHelper.beginTransaction();
		try {
			consultDAO.update(consult);
			EntityManagerHelper.commit();
			
			SimConsult simConsult = new SimConsult();
			simConsult.fromConsult(consult);
			
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			JsonObject jsonObject = new JsonParser().parse(gson.toJson(simConsult)).getAsJsonObject();
			JPushUtil.sendPush(consult.getUser().getUsername(), "专家回复", jsonObject);
			this.out(response, "1");
		} catch (RuntimeException re) {
			this.out(response, "0");
		}
	}

	/**
	 * 未解决
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void consulting(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ConsultDAO consultDAO = new ConsultDAO();
		List<Consult> consults = consultDAO.findByStatus(0);
		request.getSession().setAttribute("consulting", consults);
		response.sendRedirect("manage/consult.jsp");
	}
	
	/**
	 * 已解决
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void consulted(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ConsultDAO consultDAO = new ConsultDAO();
		List<Consult> consults = consultDAO.findByStatus(1);
		request.getSession().setAttribute("consulted", consults);
		response.sendRedirect("manage/consulted.jsp");
	}
}
