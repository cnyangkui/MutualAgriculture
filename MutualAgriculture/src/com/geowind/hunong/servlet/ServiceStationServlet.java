package com.geowind.hunong.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geowind.hunong.jpa.Servicestation;
import com.geowind.hunong.jpa.ServicestationDAO;

public class ServiceStationServlet extends BasicServlet {

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
		ServicestationDAO servicestationDAO = new ServicestationDAO();
		List<Servicestation> servicestationList = servicestationDAO.findAll();
		if(servicestationList!=null&&servicestationList.size()>0){
			this.out(response, servicestationList);
		}else{
			this.out(response,0);
		}
	}

}
