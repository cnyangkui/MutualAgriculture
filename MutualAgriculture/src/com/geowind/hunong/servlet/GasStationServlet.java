package com.geowind.hunong.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geowind.hunong.jpa.Gasstation;
import com.geowind.hunong.jpa.GasstationDAO;

public class GasStationServlet extends BasicServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String op = request.getParameter("op");
		
		switch(op){
		
			case "MapSearchAll":
				MapSearchAll(request,response);
				break;
			default:
				break;
		}
	}

	private void MapSearchAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		GasstationDAO gasstationDAO = new GasstationDAO();
		List<Gasstation> gasstationList = gasstationDAO.findAll();
		if(gasstationList!=null&&gasstationList.size()>0){
			this.out(response, gasstationList);
		}else{
			this.out(response, 0);
		}
	}
	

}
