package com.geowind.hunong.dao;

import java.util.List;
import java.util.Map;

import com.geowind.hunong.jpa.Machineowner;


/**
 * Created by Kui on 2016/9/3.
 */
public interface MachineOwnerDao {

    public int insertMachineOwner(Machineowner machineOwner);
    
    public List<Map<String, Object>> search(int centerId);
}
