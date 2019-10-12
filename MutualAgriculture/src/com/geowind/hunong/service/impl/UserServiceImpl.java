package com.geowind.hunong.service.impl;

import com.geowind.hunong.dao.UserDao;
import com.geowind.hunong.dao.impl.UserDaoImpl;
import com.geowind.hunong.jpa.Center;
import com.geowind.hunong.jpa.CenterDAO;
import com.geowind.hunong.jpa.User;
import com.geowind.hunong.service.UserService;
import com.geowind.hunong.util.Encrypt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Kui on 2016/7/20.
 */
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	@Override
	public String login(String userId, String password) {
		// String encryptPassword = Encrypt.md5AndSha(password);
		Map<String, Object> result = userDao.selectAccounts(userId, password);
		if (result != null) {
			return "登录成功";
		}
		return "登录失败";
	}
	
	
	@Override
	public List<User> search(int centerId, String type) {
		List<Map<String, Object>> maps = userDao.search(centerId, type);
		List<User> list = new ArrayList<User>();
		for(Map<String, Object> map : maps) {
			User user = new User();
			user.setUsername((String)map.get("username"));
			user.setPassword((String)map.get("password"));
			user.setRealname((String)map.get("realname"));
			user.setSex((String)map.get("sex"));
			user.setBirthday((Date)map.get("birthday"));
			user.setPhone((String)map.get("phone"));
			user.setType((int)map.get("type"));
			user.setPicture((String)map.get("picture"));
			user.setAddress((String)map.get("address"));
			user.setCredit((String)map.get("credit"));
			/*Center center = new Center();
			center.setCenterId((int)map.get("centerid"));*/
			CenterDAO centerDAO = new CenterDAO();
			Center center = centerDAO.findById((int)map.get("centerid"));
			user.setCenter(center);
			user.setValid((int)map.get("valid"));
			list.add(user);
		}
		return list;
	}

	@Override
	public List<User> findFreeUser(int centerId, String type) {
		List<Map<String, Object>> maps = userDao.findFreeUser(centerId, type);
		List<User> list = new ArrayList<User>();
		for(Map<String, Object> map : maps) {
			User user = new User();
			user.setUsername((String)map.get("username"));
			user.setPassword((String)map.get("password"));
			user.setRealname((String)map.get("realname"));
			user.setSex((String)map.get("sex"));
			user.setBirthday((Date)map.get("birthday"));
			user.setPhone((String)map.get("phone"));
			user.setType((int)map.get("type"));
			user.setPicture((String)map.get("picture"));
			user.setAddress((String)map.get("address"));
			user.setCredit((String)map.get("credit"));
			CenterDAO centerDAO = new CenterDAO();
			Center center = centerDAO.findById((int)map.get("centerid"));
			user.setCenter(center);
			user.setValid((int)map.get("valid"));
			list.add(user);
		}
		return list;
	}
}
