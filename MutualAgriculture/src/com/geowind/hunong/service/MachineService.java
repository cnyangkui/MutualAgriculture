package com.geowind.hunong.service;

import java.util.List;

import com.geowind.hunong.entity.MachineNum;
import com.geowind.hunong.jpa.Machine;


/**
 * Created by Kui on 2016/9/4.
 */
public interface MachineService {

    public int addMachineInfo(Machine machine);

	public List<Machine> findFreeMachine();
	
	public List<MachineNum> getMachineNum();
}
