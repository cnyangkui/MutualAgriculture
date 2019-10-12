package com.geowind.hunong.servlet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import com.geowind.hunong.util.DBHelper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jspsmart.upload.Request;

public class TreeServlet extends BasicServlet {

	

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	
		
		String op = request.getParameter("op");
		
		switch(op){
		
			case "getTreeJson":
				getTreeJson(request, response);
			
			default:
				break;
		}
		
		
		
	
	}
	
	
	
	public void getTreeJson(HttpServletRequest request, HttpServletResponse sresponse){
		//获取服务中心
		String sql = "select * from center;";
		List<Map<String,Object>> maps = DBHelper.doQuery(sql);
		
		JsonObject centerObject = new JsonObject(); //中心 对象
		JsonArray zoneArray = new JsonArray();  //区 数组

		for(Map<String,Object> map:maps){
			//设置服务中心节点对象
			centerObject.addProperty("name", map.get("name").toString());
			
			//获取区 数组
			zoneArray  = getZoneJson(map.get("centerid").toString());
			
			//将区 数组放入服务中心 对象
			centerObject.add("children", zoneArray);
		}
		try{
			
			String s = centerObject.toString();
			
			//URL base = this.getClass().getResource("");
			//String path = new File(base.getFile(), "../../").getCanonicalPath(); 
		
			String dirString = request.getSession().getServletContext().getRealPath("")+File.separator+"jsonData";
			File dir = new File(dirString);
			if(!dir.exists()) {
				dir.mkdirs();
			}
			
			File treeJsonFile = new File(request.getSession().getServletContext().getRealPath("")+File.separator+"jsonData"+File.separator+"tree.json");
			
			
			if(!treeJsonFile.exists()){
				treeJsonFile.createNewFile();
			}
			FileWriter fw = new FileWriter(treeJsonFile.getPath());
			
			
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(s);
			bw.close();
			
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
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
			//获取农田数组
			farmlandArray = getFarmlandJson(map.get("bid").toString());
			
			//将农田数组 放入块对象中			
			blockObject.add("children",farmlandArray);
			
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
			
			//将农田对象放入农田数组			
			farmlandArray.add(farmlandObject);
			
		}
		
		
		return farmlandArray;
	}
	
	
	

}
