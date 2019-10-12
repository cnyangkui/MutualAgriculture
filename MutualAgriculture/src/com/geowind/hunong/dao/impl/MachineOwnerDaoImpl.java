package com.geowind.hunong.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.geowind.hunong.jpa.Center;
import com.geowind.hunong.jpa.Machineowner;
import com.geowind.hunong.jpa.User;
import com.geowind.hunong.dao.MachineOwnerDao;
import com.geowind.hunong.util.DBHelper;

/**
 * Created by Kui on 2016/9/3.
 */
public class MachineOwnerDaoImpl implements MachineOwnerDao {


    @Override
    public int insertMachineOwner(Machineowner machineOwner) {
        String sql = "insert into machineowner values(null, ?, ?, ?)";
        return DBHelper.doUpdate(sql, machineOwner.getPhone(), machineOwner.getName(), machineOwner.getAddress());
    }
    
    @Override
    public List<Map<String, Object>> search(int centerId) {
    	//List<Machineowner> list = new ArrayList<Machineowner>();
    	String sql = "select * from machineowner where valid = 1 and centerId=?";
    	return DBHelper.doQuery(sql, centerId);
    	/*Connection con = DBHelper.getConn();
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, centerId);
			rs = ps.executeQuery();
			while(rs.next()) {
				Machineowner machineowner = new Machineowner();
				machineowner.setOwnerId(rs.getInt(1));
				machineowner.setName(rs.getString(2));
				machineowner.setSex(rs.getString(3));
				machineowner.setBirthday(rs.getDate(4));
				machineowner.setPhone(rs.getString(5));
				machineowner.setAddress(rs.getString(6));
				Center center = new Center();
				center.setCenterId(rs.getInt(7));
				machineowner.setCenter(center);
				machineowner.setValid(rs.getInt(8));
				list.add(machineowner);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	DBHelper.close(con, null, rs);
		return list;*/
    	
    }
}
