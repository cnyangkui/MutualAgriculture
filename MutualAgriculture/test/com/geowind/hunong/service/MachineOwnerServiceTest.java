package com.geowind.hunong.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.geowind.hunong.jpa.Center;
import com.geowind.hunong.jpa.CenterDAO;
import com.geowind.hunong.jpa.Farmland;
import com.geowind.hunong.jpa.FarmlandDAO;
import com.geowind.hunong.jpa.Machineowner;
import com.geowind.hunong.jpa.Zone;
import com.geowind.hunong.jpa.ZoneDAO;
import com.geowind.hunong.service.impl.MachineOwnerServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MachineOwnerServiceTest {

//	@Test
//	public void testSearch() {
//		MachineOwnerService machineOwnerService = new MachineOwnerServiceImpl();
//		Machineowner machineowner = new Machineowner();
//		machineowner.setName("李四");
//		List<Machineowner> list = machineOwnerService.search(1);
//		for(Machineowner m : list) {
//			System.out.println(m);
//		}
//	}
//	
	@Test
	public void test(){
		CenterDAO centerDAO = new CenterDAO();
		List<Center> centerList = centerDAO.findByValid(1);
		Center center = new Center();
//		<Center> centerArray = new ArrayList();
		for(int i = 0;i<centerList.size();i++){
//			farmland.setAddress(farmlandList.get(i).getAddress());
//			farmland.setArea(farmlandList.get(i).getArea());
//			farmland.setBlock(farmlandList.get(i).getBlock());
//			farmland.setFarmlandId(farmlandList.get(i).getFarmlandId());
//			farmland.setUser(farmlandList.get(i).getUser());
//			farmland.setZone(farmlandList.get(i).getZone());

			center.setAddress(centerList.get(0).getAddress());
			center.setAdmins(centerList.get(0).getAdmins());
			center.setCenterId(centerList.get(0).getCenterId());
			center.setLevel(centerList.get(0).getLevel());
			center.setName(centerList.get(0).getName());
			center.setPrincipal(centerList.get(0).getPrincipal());
			center.setMachineowners(centerList.get(0).getMachineowners());
			center.setTasks(centerList.get(0).getTasks());
			center.setUsers(centerList.get(0).getUsers());
			center.setZones(centerList.get(0).getZones());
			center.setValid(centerList.get(0).getValid());
//			centerArray.add(center);
		}
		
//		Gson gson = new GsonBuilder()
//	               .registerTypeAdapter(Center.class, new MyAdapter<Center>())
//	               .create();
		
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String s = gson.toJson(center);
		//gson.toJson(centerList);
		System.out.println("zone is ="+s);
	}
	
//	@Test
//	public void testZone(){
//		
//		ZoneDAO zoneDAO = new ZoneDAO();
//		List<Zone> zoneList = zoneDAO.findByValid(1);
//		
//		Zone zone  = new Zone();
//		for(int i = 0;i<zoneList.size();i++){
////			zone.setAddress(zoneList.get(0).getAddress());
////			zone.setArea(zoneList.get(0).getArea());
//			zone.setBlocks(zoneList.get(0).getBlocks());
//			zone.setCenter(zoneList.get(0).getCenter());
//			zone.setFarmlands(zoneList.get(0).getFarmlands());
//			zone.setZoneId(zoneList.get(0).getZoneId());
//			zone.setZonename(zoneList.get(0).getZonename());
////			zone.setType(zoneList.get(0).getType());
//			
//		}
//		
//		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
//		String s = gson.toJson(zone);
//		System.out.println(s);
//	}

	
//	 @Test
//	 public void testFarmland(){
//		 
//		 FarmlandDAO farmlandDAO = new FarmlandDAO();
//		 List<Farmland> farmlandList = farmlandDAO.findByValid(1);
//		 
//		 ArrayList<Farmland> farmlandArray = new ArrayList();
//		 for(int i=0;i<farmlandList.size();i++){
//			 	Farmland farmland = new Farmland();
//				farmland.setAddress(farmlandList.get(i).getAddress());
//				farmland.setArea(farmlandList.get(i).getArea());
//				farmland.setBlock(farmlandList.get(i).getBlock());
//				farmland.setFarmlandId(farmlandList.get(i).getFarmlandId());
//				farmland.setUser(farmlandList.get(i).getUser());
//				farmland.setZone(farmlandList.get(i).getZone());
//				farmlandArray.add(farmland);
//		 }
//		 
//		 Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
//		 String s = gson.toJson(farmlandArray);
//		 System.out.println("size is ="+farmlandList.size()+" s= "+s);
//	 }
//	


}
