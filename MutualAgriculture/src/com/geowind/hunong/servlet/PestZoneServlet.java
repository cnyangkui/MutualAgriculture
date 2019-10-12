package com.geowind.hunong.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geowind.hunong.entity.FarmlandPoint;
import com.geowind.hunong.entity.Point;
import com.geowind.hunong.jpa.Block;
import com.geowind.hunong.jpa.Farmland;
import com.geowind.hunong.jpa.FarmlandDAO;
import com.geowind.hunong.jpa.Pestzone;
import com.geowind.hunong.jpa.PestzoneDAO;
import com.geowind.hunong.jpa.Zone;
import com.geowind.hunong.util.PointSelector;

public class PestZoneServlet extends BasicServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String op = request.getParameter("op");
		
		switch(op){
		
			case "MapSearchAll":
				MapSearchAll(request,response);
				break;
				
			case "MapSearchAffectedArea":		
				MapSearchAffectedArea(request,response);
				break;
			default:
				break;
		}
 	
	
	}

	
	
	
	private void MapSearchAffectedArea(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PestzoneDAO pestzoneDAO = new PestzoneDAO();
		Integer in = 0;
		List<Pestzone> affectedAreaList = pestzoneDAO.findByStatus(in);
		System.out.println("aff is:"+affectedAreaList.size());
		if(affectedAreaList!=null&&affectedAreaList.size()>0){			
			this.out(response, getAffectedFarmlandPoint(affectedAreaList));
		}else{
			this.out(response, 0);
		}
		
	}

	
	/**
	 * 获得受灾区凸点经纬度
	 * @param affectedAreaList
	 * @return
	 */
	private List<FarmlandPoint> getAffectedFarmlandPoint(List<Pestzone> affectedAreaList) {
		
		//获得分区的集合，保证不重复
		Set<Zone> zoneNumber = new HashSet<Zone>();
		int d =0;
		for(int i=0;i<affectedAreaList.size();i++){
				d++;
				zoneNumber.add(affectedAreaList.get(i).getZone());
				
		} 
//		System.out.println("b is:"+d);
//		FarmlandDAO farmlandDAO =new FarmlandDAO();
		Iterator<Zone> i =zoneNumber.iterator(); 
		
		List<FarmlandPoint> farmlandPointList = new ArrayList<FarmlandPoint>();
		
		Set<Farmland> farmlandList = new HashSet<Farmland>();
		
		Set<Block> blockSet = new HashSet<Block>();
	
		//遍历受灾的农田分区
		while(i.hasNext()){
			List<Point> p = new ArrayList<Point>();
			//获得该指定分区下的所有农田
			blockSet = i.next().getBlocks();
			
			Iterator<Block> b = blockSet.iterator();
			
			//获得分块
			while(b.hasNext()){
			

			
//			System.out.println("meile");
			
			
			
			farmlandList = b.next().getFarmlands();
			
			Iterator<Farmland> f = farmlandList.iterator();
			
			int count = 0;
			//获得农田
			while(f.hasNext()){
				
				count++;
				Point p1 = new Point();
				Farmland tmp = f.next();
//				System.out.println(tmp.getLongitude()+","+tmp.getLatitude());
				p1.setX(tmp.getLongitude());
				p1.setY(tmp.getLatitude());
				
				p.add(p1);
				
			}
//			System.out.println("count is" + count);
			}
			
			PointSelector ps = new PointSelector(p);
			p = ps.GetHullPoints();
			
			FarmlandPoint fp = new FarmlandPoint();
			fp.setPointList(p);
			farmlandPointList.add(fp);
		}
		
			
		return farmlandPointList;
	}




	private void MapSearchAll(HttpServletRequest request, HttpServletResponse response) throws IOException {

		PestzoneDAO pestzoneDAO = new PestzoneDAO();
		List<Pestzone> pestzoneList = pestzoneDAO.findAll();
		if(pestzoneList!=null&&pestzoneList.size()>0){
			this.out(response,pestzoneList);
		}else{
			this.out(response, 0);
		}
		
		
	}

}
