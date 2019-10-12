package com.geowind.hunong.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geowind.hunong.jpa.Pestquestion;
import com.geowind.hunong.jpa.PestquestionDAO;

public class PestQuestionServlet extends BasicServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String op = request.getParameter("op");
		
		switch(op){
		
			case "MapSearchAll":
				MapSearchAll(request,response);
				break;
			case "question":
				question(request, response);
				break;
			default:
				break;

				
		}
	
	}

	private void question(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PestquestionDAO pestquestionDAO = new PestquestionDAO();
		List<Pestquestion> pestquestionList = pestquestionDAO.findByStatus(0);
		request.getSession().setAttribute("questions", pestquestionList);
		response.sendRedirect("manage/pestidentification.jsp");
	}

	private void MapSearchAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		PestquestionDAO pestquestionDAO = new PestquestionDAO();
		List<Pestquestion> pestquestionList = pestquestionDAO.findAll();
		if(pestquestionList!=null&&pestquestionList.size()>0){
			this.out(response, pestquestionList);
		}else{
			this.out(response, 0);
		}
		
	}

}
