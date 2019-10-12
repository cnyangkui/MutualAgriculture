package com.geowind.hunong.service;


import java.util.List;

import com.geowind.hunong.jpa.Task;

/**
 * Created by Kui on 2016/7/21.
 */
public interface TaskService {

    public List<Task> getTaskInfo(int centerId, int isFinished);
    
    public List<Task> historyTaskByUser(int centerId, int isFinished, String username);
}
