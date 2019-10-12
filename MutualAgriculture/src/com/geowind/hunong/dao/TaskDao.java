package com.geowind.hunong.dao;

import java.util.List;
import java.util.Map;

import com.geowind.hunong.jpa.Task;

/**
 * Created by Kui on 2016/7/21.
 */
public interface TaskDao {

	public List<Map<String, Object>> getTaskInfo(int centerId, int isFinished);
	
	public List<Map<String, Object>> historyTaskByUser(int centerId, int isFinished, String username);
}
