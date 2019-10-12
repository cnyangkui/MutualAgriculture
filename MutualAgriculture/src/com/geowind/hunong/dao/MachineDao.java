package com.geowind.hunong.dao;

import java.util.List;
import java.util.Map;

import com.geowind.hunong.jpa.Machine;




/**
 * Created by Kui on 2016/9/4.
 */
public interface MachineDao {

    public int insertMachine(Machine machine);

	public List<Map<String, Object>> findFreeUser();
}
