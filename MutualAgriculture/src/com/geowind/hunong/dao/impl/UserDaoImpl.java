package com.geowind.hunong.dao.impl;

import com.geowind.hunong.dao.UserDao;
import com.geowind.hunong.util.DBHelper;

import java.util.List;
import java.util.Map;

/**
 * Created by Kui on 2016/7/20.
 */
public class UserDaoImpl implements UserDao {
    @Override
    public Map<String, Object> selectAccounts(String userId, String password) {
        String sql = "select * from user where username=? and password=?";
        return DBHelper.doQueryOne(sql, userId, password);
    }
    
    @Override
    public List<Map<String, Object>> search(int centerId, String type) {
    	String sql = "select * from " + type + " where centerId=? and valid=1";
    	return DBHelper.doQuery(sql ,centerId);
    	
    }

	@Override
	public List<Map<String, Object>> findFreeUser(int centerId, String type) {
		String sql = "select * from " + type + " where centerId=? and valid=1 and status = 0";
    	return DBHelper.doQuery(sql ,centerId);
	}
}
