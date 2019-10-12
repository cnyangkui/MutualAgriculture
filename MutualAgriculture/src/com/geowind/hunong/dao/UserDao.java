package com.geowind.hunong.dao;


import java.util.List;
import java.util.Map;

import com.geowind.hunong.jpa.User;

/**
 * Created by Kui on 2016/7/19.
 */
public interface UserDao {

    public Map<String, Object> selectAccounts(String userId, String password);
    
    public List<Map<String, Object>> search(int centerId, String type);

	public List<Map<String, Object>> findFreeUser(int centerId, String type); 

}
