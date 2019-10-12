package com.geowind.hunong.service;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.geowind.hunong.jpa.Center;
import com.geowind.hunong.jpa.Zone;
import com.geowind.hunong.util.DBHelper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class TestJson {

	//@Test
	public void testJson(){
		JsonObject objectWorld = new JsonObject();
		objectWorld.addProperty("name", "China");
		
		JsonArray arrayWorld = new JsonArray();
//		arrayWorld.addProperty("name","China");
    
	    JsonObject objectProvince = new JsonObject();
	    objectProvince.addProperty("name", "zhejiang");
		
	    
		JsonArray children = new JsonArray(); // 创建json数组
	    JsonObject objectCity = new JsonObject();
	    
	    objectCity.addProperty("name", "hangzhou");
	    children.add(objectCity);               // 将json对象添加到数组  
	    
	    objectCity = new JsonObject();
	    objectCity.addProperty("name", "ningbo");
//	    language.addProperty("ide", "XCode");
//	    language.addProperty("name", "Swift");
	    children.add(objectCity);				// 将json对象添加到数组  

	    objectCity = new JsonObject();
	    objectCity.addProperty("name", "wenzhou");
//	    language.addProperty("ide", "Visual Studio");
//	    language.addProperty("name", "C#");
	    children.add(objectCity);                // 将json对象添加到数组  
	    
	    objectProvince.add("children", children);   //将json数组添加到对象中
	    
	    arrayWorld.add(objectProvince);   //将json对象添加到数组中
	    
	    //将json数组添加到对象中
	    objectWorld.add("children", arrayWorld);
	    System.out.println(objectWorld);
	    
	    
	}
	
	@Test
	public void getTreeJson(){
		
		//获取服务中心
		String sql = "select * from center;";
		List<Map<String,Object>> maps = DBHelper.doQuery(sql);
		
		JsonObject centerObject = new JsonObject(); //中心 对象
		JsonArray zoneArray = new JsonArray();  //区 数组

		for(Map<String,Object> map:maps){
			//设置服务中心节点对象
			centerObject.addProperty("name", map.get("name").toString());
			
//			System.out.println("centerId is="+map.get("centerid").toString());
			//获取区 数组
			zoneArray  = getZoneJson(map.get("centerid").toString());
			
			//将区 数组放入服务中心 对象
			centerObject.add("children", zoneArray);
		}
		
		System.out.println(centerObject.toString());		
		
	}

	
	/**
	 * 获取zone的json数据
	 * @param string
	 */
	private JsonArray getZoneJson(String centerId) {
		
		String sql = "select zoneId,zonename from zone where centerId = "+centerId+";";
		List<Map<String,Object>> maps = DBHelper.doQuery(sql);
		
		JsonObject zoneObject = new JsonObject();  //设置区节点对象
		
		JsonArray zoneArray = new JsonArray();    //设置区 数组
		
		JsonArray blockArray = new JsonArray();     //块 数组
		
		
		
		for(Map<String,Object> map : maps){
			
			zoneObject = new JsonObject();    
			zoneObject.addProperty("name", map.get("zonename").toString());
			
	
			//获取块 数组
			blockArray = getBlockJson(map.get("zoneid").toString());
			
			//将块数组放入区对象中
			zoneObject.add("children", blockArray);  
			
			//将区 对象 放入区 数组 中返回
			zoneArray.add(zoneObject);
		}
		
		return zoneArray;
		
	}
	

	/**
	 * 获取块数组
	 * @param string
	 * @return
	 */
	private JsonArray getBlockJson(String zoneId) {
		
		String sql = "select bid , bname from block where zoneId = "+ zoneId +";";
		System.out.println("zoneId is="+zoneId);
		List<Map<String,Object>> maps = DBHelper.doQuery(sql);
		
		//块 对象
		JsonObject blockObject = new JsonObject();
		//块 数组
		JsonArray blockArray = new JsonArray();
		//农田 数组
		JsonArray farmlandArray = new JsonArray();
		
		for(Map<String,Object> map : maps){
			blockObject = new JsonObject();
			blockObject.addProperty("name", map.get("bname").toString());
			System.out.println("blockname is="+map.get("bname").toString());
			//获取农田数组
			//farmlandArray = getFarmlandJson(map.get("bid").toString());
			
			//将农田数组 放入块对象中			
			//blockObject.add("children",farmlandArray);
			
			//将块对象放入块数组
			blockArray.add(blockObject);
			
		}
		
		
		return blockArray;
	}

	/**
	 * 获取农田数组
	 * @param string
	 * @return
	 */
	private JsonArray getFarmlandJson(String blockId) {
		
		String sql = "select farmlandId,bid from farmland where bid = "+blockId+";";
		List<Map<String,Object>> maps = DBHelper.doQuery(sql);
		//农田对象
		JsonObject farmlandObject = new JsonObject();
		//农田数组
		JsonArray farmlandArray = new JsonArray();
		
		for(Map<String,Object> map : maps){
			farmlandObject = new JsonObject();
			farmlandObject.addProperty("name", map.get("farmlandid").toString());
			//System.out.println("农田数据："+map.get("farmlandid").toString());
			
			//将农田对象放入农田数组			
			farmlandArray.add(farmlandObject);
			
		}
		
		
		return farmlandArray;
	}
	
}
