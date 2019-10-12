package com.geowind.hunong.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geowind.hunong.jpa.Center;
import com.geowind.hunong.jpa.CenterDAO;

public class CenterServlet extends BasicServlet {


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String op = request.getParameter("op");
		
		switch(op){
			case "MapSearchAll":
				MapSearchAll(request,response);
				break;
			
		}
	
	
	
	}

	private void MapSearchAll(HttpServletRequest request, HttpServletResponse response) throws IOException {

		CenterDAO centerDAO = new CenterDAO();
		List<Center> centerList = centerDAO.findByValid(1);
		
		if(centerList != null&&centerList.size()>0){
//			System.out.println("查询到");
			this.out(response, centerList);
		}else{
			//跳转错误界面
//			System.out.println("没有查询到");
		}
		
	}
	
	

}
