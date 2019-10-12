package com.geowind.hunong.service;

import java.util.List;

import com.geowind.hunong.jpa.Machineowner;


/**
 * Created by Kui on 2016/9/3.
 */
public interface MachineOwnerService {

    public int addMachineOwnerInfo(Machineowner machineOwner);
    
    public List<Machineowner> search(int centerId);
}
