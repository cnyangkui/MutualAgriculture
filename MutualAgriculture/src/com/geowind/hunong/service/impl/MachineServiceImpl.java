package com.geowind.hunong.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.geowind.hunong.jpa.Center;
import com.geowind.hunong.jpa.CenterDAO;
import com.geowind.hunong.jpa.Machine;
import com.geowind.hunong.jpa.MachineownerDAO;
import com.geowind.hunong.jpa.User;
import com.geowind.hunong.dao.MachineDao;
import com.geowind.hunong.dao.impl.MachineDaoImpl;
import com.geowind.hunong.entity.MachineNum;
import com.geowind.hunong.service.MachineService;
import com.geowind.hunong.util.DBHelper;

/**
 * Created by Kui on 2016/9/4.
 */
public class MachineServiceImpl implements MachineService {

    private MachineDao machineDao;

    public MachineServiceImpl() {
        machineDao = new MachineDaoImpl();
    }

    @Override
    public int addMachineInfo(Machine machine) {
        return machineDao.insertMachine(machine);
    }

	@Override
	public List<Machine> findFreeMachine() {
		List<Map<String, Object>> maps = machineDao.findFreeUser();
		List<Machine> list = new ArrayList<Machine>();
		for(Map<String, Object> map : maps) {
			Machine machine = new Machine();
			machine.setMachineId((int)map.get("machineid"));
			machine.setBrand((String)map.get("brand"));
			machine.setHorsepower((String)map.get("horsepower"));
			MachineownerDAO machineownerDAO = new MachineownerDAO();
			machine.setMachineowner(machineownerDAO.findById((int)map.get("ownerid")));
			machine.setOverdate((Date)map.get("overdate"));
			machine.setPicture((String)map.get("picture"));
			machine.setPlate((String)map.get("plate"));
			machine.setState((int)map.get("state"));
			machine.setType((String)map.get("type"));
			machine.setValid((int)map.get("valid"));
			machine.setWorkstate((int)map.get("workstate"));
			list.add(machine);
		}
		return list;
	}

	@Override
	public List<MachineNum> getMachineNum() {

		
		String sql = "select count(machineid) as num,type from machine group by type";
		List<Map<String,Object>> maps = DBHelper.doQuery(sql);
		List<MachineNum> machineList = new ArrayList<MachineNum>();
		for(Map<String,Object> map : maps){
			
			System.out.println(map.get("type") + "  "+map.get("num"));
			
			MachineNum machineNum = new MachineNum();
			machineNum.setType((String)map.get("type"));
			machineNum.setNum(String.valueOf(map.get("num")));
			
			machineList.add(machineNum);
		}
		
		return machineList ;
	}
}
