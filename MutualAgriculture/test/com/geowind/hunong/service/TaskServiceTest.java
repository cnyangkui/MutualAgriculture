package com.geowind.hunong.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.geowind.hunong.jpa.Task;
import com.geowind.hunong.service.impl.TaskServiceImpl;

public class TaskServiceTest {

	@Test
	public void testGetTaskInfo() {
		TaskService taskService = new TaskServiceImpl();
		List<Task> tasks = taskService.getTaskInfo(10001, 1);
		System.out.println(tasks);
	}

}
