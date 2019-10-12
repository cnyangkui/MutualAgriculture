package com.geowind.hunong.servlet;

import com.geowind.hunong.jpa.Center;
import com.geowind.hunong.jpa.CenterDAO;
import com.geowind.hunong.jpa.EntityManagerHelper;
import com.geowind.hunong.jpa.User;
import com.geowind.hunong.jpa.UserDAO;
import com.geowind.hunong.service.UserService;
import com.geowind.hunong.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.persistence.internal.oxm.mappings.Login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kui on 2016/7/20.
 */
@WebServlet(name = "UserServlet")
public class UserServlet extends BasicServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
    	
        String methodName = request.getParameter("method");
//        System.out.println(methodName);
        /*if (methodName == null) {
            resultJson = null;
        } else {
            // 根据请求的方法，返回对应信息 resultJson
            resultJson = dealWithRequest(methodName, request);
        }
        //response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        System.out.println(resultJson);
        response.getWriter().write(resultJson);*/
        
        switch (methodName) {
		case "login":
			login(request, response);
			break;
		case "register":
			register(request, response);
			break;
		case "getCenter":
			getCenter(request, response);
			break;
		
		default:
			break;
		}
    }


 


	/**
     * 注册前获取所有中心信息
     * @param request
     * @param response
     * @throws IOException
     */
    private void getCenter(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
    	CenterDAO centerDAO = new CenterDAO();
    	List<Center> list = centerDAO.findAll();
    	List<String> nameList = new ArrayList<String>();
    	for(Center center : list) {
    		nameList.add(center.getName());
    	}
		this.out(response, nameList);
	}


    /**
     * 注册
     * @param request
     * @param response
     * @throws IOException
     */
	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		UserDAO userDAO = new UserDAO();
		
		User user = new User();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String realname = request.getParameter("realname");
		String phone = request.getParameter("phone");
		int type = Integer.parseInt(request.getParameter("type"));
		String centername = request.getParameter("centername");
		
//		System.out.println(username +" "+password+ " "+realname+ " "+phone+" "+type+" "+centername);
		
		user.setUsername(username);
		user.setPassword(password);
		user.setRealname(realname);
		user.setPhone(phone);
		user.setType(type);
		List<Center> centerList = new CenterDAO().findByName(centername);
		if(centerList != null && centerList.size()>0) {
			Center center = centerList.get(0);
			user.setCenter(center);
		}
		
		EntityManagerHelper.beginTransaction();
		try {
			userDAO.save(user);
			EntityManagerHelper.commit();
			this.out(response, "1");
		} catch (RuntimeException re) {
			this.out(response, "0");
		}
	}


	/**
     * 登录
     * @param request
     * @param response
     * @throws IOException
     */
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        System.out.println(username + " " + password);
        UserDAO userDAO = new UserDAO();
        User user = userDAO.findById(username);
        if(user != null) {
        	if(user.getPassword().equals(password)) {
        		this.out(response, user);
        	}
        }
    }


}
