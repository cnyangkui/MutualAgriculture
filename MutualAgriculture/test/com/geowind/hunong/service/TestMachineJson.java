package com.geowind.hunong.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.geowind.hunong.entity.Data;
import com.geowind.hunong.jpa.Machine;
import com.geowind.hunong.jpa.MachineDAO;
import com.geowind.hunong.util.DBHelper;
import com.google.gson.Gson;

public class TestMachineJson {
	
	@Test
	public void test(){
		String sql = "select count(machineid) as num,type from machine group by type";
		List<Map<String,Object>> maps = DBHelper.doQuery(sql);
		
		
		Gson gson = new Gson();
		
		System.out.println(gson.toJson(maps));
	}

}
