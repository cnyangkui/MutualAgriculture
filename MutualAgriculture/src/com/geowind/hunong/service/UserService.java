package com.geowind.hunong.service;

import java.util.List;
import java.util.Map;

import com.geowind.hunong.jpa.User;

/**
 * Created by Kui on 2016/7/20.
 */
public interface UserService {

    public String login(String userId, String password);
    
    public List<User> search(int centerId, String type);

	public List<User> findFreeUser(int centerId, String type);
}
