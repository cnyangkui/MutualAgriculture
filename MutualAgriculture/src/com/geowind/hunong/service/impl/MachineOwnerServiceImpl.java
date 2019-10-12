package com.geowind.hunong.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.geowind.hunong.jpa.Center;
import com.geowind.hunong.jpa.Machineowner;
import com.geowind.hunong.dao.MachineOwnerDao;
import com.geowind.hunong.dao.impl.MachineOwnerDaoImpl;
import com.geowind.hunong.service.MachineOwnerService;

/**
 * Created by Kui on 2016/9/3.
 */
public class MachineOwnerServiceImpl implements MachineOwnerService {

    private MachineOwnerDao machineOwnerDao;

    public MachineOwnerServiceImpl() {
        machineOwnerDao = new MachineOwnerDaoImpl();
    }

    @Override
    public int addMachineOwnerInfo(Machineowner machineOwner) {
        return  machineOwnerDao.insertMachineOwner(machineOwner);
    }

	@Override
	public List<Machineowner> search(int centerId) {
		List<Map<String, Object>> maps = machineOwnerDao.search(centerId);
		List<Machineowner> list = new ArrayList<Machineowner>();
		for(Map<String, Object> map : maps) {
			Machineowner machineowner = new Machineowner();
			machineowner.setOwnerId((int)map.get("ownerid"));
			machineowner.setName((String)map.get("name"));
			machineowner.setSex((String)map.get("sex"));
			machineowner.setBirthday((Date)map.get("birthday"));
			machineowner.setPhone((String)map.get("phone"));
			machineowner.setAddress((String)map.get("address"));
			Center center = new Center();
			center.setCenterId((int)map.get("centerid"));
			machineowner.setCenter(center);
			machineowner.setValid((int)map.get("valid"));
			list.add(machineowner);
		}
		return list;
	}
}
