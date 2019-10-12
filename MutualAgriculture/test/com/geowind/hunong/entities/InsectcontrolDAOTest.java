package com.geowind.hunong.entities;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.geowind.hunong.jpa.Center;
import com.geowind.hunong.jpa.CenterDAO;
import com.geowind.hunong.jpa.EntityManagerHelper;
import com.geowind.hunong.jpa.Insectcontrol;
import com.geowind.hunong.jpa.InsectcontrolDAO;
import com.geowind.hunong.jpa.UserDAO;
import com.geowind.hunong.jpa.Zone;
import com.geowind.hunong.jpa.ZoneDAO;
import com.geowind.hunong.servlet.BZoneServlet;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class InsectcontrolDAOTest {

//	@Test
//	public void testSave() {
//		InsectcontrolDAO insectcontrolDAO = new InsectcontrolDAO();
//    	Insectcontrol insectcontrol = new Insectcontrol();
//    	insectcontrol.setUploadImage("images");
//    	insectcontrol.setDescr("describe");
//    	UserDAO userDAO = new UserDAO();
//    	insectcontrol.setUser(userDAO.findById("geowind"));
//    	insectcontrol.setUploadtime(new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date()));
//    	EntityManagerHelper.beginTransaction();
//    	try {
//    		insectcontrolDAO.save(insectcontrol);
//    		EntityManagerHelper.commit();
//    	} catch (RuntimeException re) {
//    		re.printStackTrace();
//    	}
//	}
//
//	@Test
//	public void testUpdate() {
//		fail("Not yet implemented");
//	}
	
//	@Test
//	public void inquiryZone(){
//		//BZoneServlet zoneServlet = new BZoneServlet();
////		ZoneDAO zoneDao = new ZoneDAO();
////	
////		List<Zone> zoneList = zoneDao.findAll();
////		
////		String z = zoneList.toString();
////		
////		System.out.println(z);
//		CenterDAO centerDAO = new CenterDAO();
//		
//		List<Center> centerList = centerDAO.findAll();
//		
//		String s = centerList.toString();
//		System.out.println(s);
//	}
	
	@Test
	public void testJson() throws IOException{
		JsonObject object = new JsonObject();  // 创建一个json对象
	    object.addProperty("name", "hangzhou");       // 为json对象添加属性   
	    
	    JsonArray languages = new JsonArray(); // 创建json数组
	    JsonObject language = new JsonObject();
	    language.addProperty("id", 1);
	    language.addProperty("ide", "Eclipse");
	    language.addProperty("name", "java");
	    languages.add(language);               // 将json对象添加到数组  
	    
	    System.out.println(languages);
	    language = new JsonObject();
	    language.addProperty("id", 2);
	    language.addProperty("ide", "XCode");
	    language.addProperty("name", "Swift");
	    languages.add(language);

	    language = new JsonObject();
	    language.addProperty("id", 3);
	    language.addProperty("ide", "Visual Studio");
	    language.addProperty("name", "C#");
	    languages.add(language);

	    object.add("languages", languages);   // 将数组添加到json对象   
	    object.addProperty("podthfthtffhbgfp", true);

	    String jsonStr = object.toString();   // 将json对象转化成json字符串
	    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("data.json")));
	    pw.print(jsonStr);
	    pw.flush();
	    pw.close();
	}

}
