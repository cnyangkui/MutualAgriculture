package com.geowind.hunong.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geowind.hunong.jpa.Consult;
import com.geowind.hunong.jpa.ConsultDAO;
import com.geowind.hunong.jpa.EntityManagerHelper;
import com.geowind.hunong.jpa.Pestquestion;
import com.geowind.hunong.jpa.PestquestionDAO;
import com.geowind.hunong.jpa.User;
import com.geowind.hunong.jpa.UserDAO;
import com.geowind.hunong.util.FileUploadUtil;

public class PestOrConsultInfoUploadServlet extends BasicServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		ServletConfig servletConfig = this.getServletConfig();
		FileUploadUtil.PATH = "../HN_upload/imgupload";
        FileUploadUtil uploadUtil = new FileUploadUtil();
        PrintWriter out = null;
        try {
            Map<String, String> map = uploadUtil.upload(servletConfig, request, response);
            out = response.getWriter();
            if(map != null && map.size()>0) {
            	
            	if(map.containsKey("images")) {
            		pestInfo(request, response, map);
            	} else {
            		consultInfo(request, response, map);
            	}
            }
            this.out(response, "1");
        } catch (Exception e) {
            e.printStackTrace();
            this.out(response, "0");
        } finally {
        	out.flush();
            out.close();
        }
	}

	/**
	 * 病虫信息
	 * @param request
	 * @param response
	 * @param map
	 * @throws IOException
	 */
	private void pestInfo(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> map) throws IOException {
		PestquestionDAO pestquestionDAO = new PestquestionDAO();
    	Pestquestion pestquestion = new Pestquestion();
    	
    	pestquestion.setUploadPic(map.get("images"));
    	pestquestion.setDescr(map.get("describe"));
    	UserDAO userDAO = new UserDAO();
    	pestquestion.setUser(userDAO.findById(map.get("username")));
    	pestquestion.setUtime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    	pestquestion.setStatus(0);
    	EntityManagerHelper.beginTransaction();
    	try {
    		pestquestionDAO.save(pestquestion);
    		EntityManagerHelper.commit();
    	} catch (RuntimeException re) {
    		re.printStackTrace();
    		this.out(response, "0");
    	}
	}

	/**
	 * 咨询信息
	 * @param request
	 * @param response
	 * @param map
	 * @throws IOException 
	 */
	private void consultInfo(HttpServletRequest request,
			HttpServletResponse response, Map<String, String> map) throws IOException {
		ConsultDAO consultDAO = new ConsultDAO();
		Consult consult = new Consult();
		UserDAO userDAO = new UserDAO();
		User user = userDAO.findById(map.get("username"));
		if(user == null) {
			this.out(response, "0");
			return;
		}
		consult.setUser(user);
		consult.setCcontent(map.get("describe"));
		consult.setCtime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		consult.setStatus(0);
		consult.setKeywords(map.get("keywords"));
		EntityManagerHelper.beginTransaction();
    	try {
    		consultDAO.save(consult);
    		EntityManagerHelper.commit();
    	} catch (RuntimeException re) {
    		re.printStackTrace();
    		this.out(response, "0");
    	}
	}

}
