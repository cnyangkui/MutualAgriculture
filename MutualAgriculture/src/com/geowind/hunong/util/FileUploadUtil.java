package com.geowind.hunong.util;

import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;

public class FileUploadUtil {
	public static String PATH="../HN_upload";//文件上传的路径  与项目评级 在项目部署时不会清空  /表示在server的项目级
	private static final String ALLOWED="gif,jpg,jpeg,png,doc,txt,xls,json";//允许上传文件类型
	private static final String DENIED="exe,bat,jsp,html,com";//不允许上传的文件类型
	private static final int SINGLEFILESIZE=10*1024*1024;//单个文件最大大小
	private static final int TOTALMAXSIZE=40*1024*1024;//每次上传总文件大小
	
	public Map<String,String> upload(PageContext pagecontent) throws Exception{
		Map<String,String> map = new HashMap<String, String>();
		//实例化一个SmartUpload对象
		SmartUpload su = new SmartUpload();//文件上传包的使用
		//初始化SmartUpload
		su.initialize(pagecontent);
		//设置参数
		su.setAllowedFilesList(ALLOWED);
		su.setDeniedFilesList(DENIED);
		su.setMaxFileSize(SINGLEFILESIZE);
		su.setTotalMaxFileSize(TOTALMAXSIZE);
		su.setCharset("utf-8");
		
		//开始上传
		su.upload();
		//获取转换后的请求
		Request request = su.getRequest();
		Enumeration<String> enums = request.getParameterNames();//使用集合来装获取所有普通表单元素名
		
		//循环取出每一个表单元素名已对一的值 村到map中
		String name=null;
		while(enums.hasMoreElements()){
			name=enums.nextElement();
			map.put(name,request.getParameter(name));
		}
		
		//将上传文件存到服务器路径下
		Files files = su.getFiles();
		String path = null;//文件保存路径
		String fileName =null;//文件名
		String temp="";
		String filedName = null;
		
		if(files!=null && files.getCount()>0){//说明用户文件已传上来
			Collection<File> collection = files.getCollection();
			path=pagecontent.getServletContext().getRealPath("/") + PATH;
//			System.out.println(path);
			
			java.io.File f = new java.io.File(path);
			if(!f.exists()){
				f.mkdir();//如果不存在则创
			}
			
			for(File f1:collection){//循环取出每一个上传文件
				if(!f1.isMissing()){//文件没有丢失
					filedName = f1.getFieldName();
					fileName = new Date().getTime()+"_"+new Random().nextInt(10000)+"."+f1.getFileExt();
//					System.out.println(fileName);
					//保存数据到指定文件
					f1.saveAs(path+"/"+fileName);
					
					if(!"".equals(temp)){
						temp+=",";
					}
					temp+=PATH+"/"+fileName;
				}
			}
			map.put(filedName, temp);
		}
//		System.out.println(map);
		return map;
	}
	
	
	
	public Map<String,String> upload(ServletConfig servletConfig, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{
		Map<String,String> map = new HashMap<String, String>();
		//实例化一个SmartUpload对象
		SmartUpload su = new SmartUpload();//文件上传包的使用
		//初始化SmartUpload
		su.initialize(servletConfig, httpServletRequest, httpServletResponse);
		//设置参数
		su.setAllowedFilesList(ALLOWED);
		su.setDeniedFilesList(DENIED);
		su.setMaxFileSize(SINGLEFILESIZE);
		su.setTotalMaxFileSize(TOTALMAXSIZE);
		su.setCharset("utf-8");
		
		//开始上传
		su.upload();
		//获取转换后的请求
		Request request = su.getRequest();
		Enumeration<String> enums = request.getParameterNames();//使用集合来装获取所有普通表单元素名
		
		//循环取出每一个表单元素名已对一的值 村到map中
		String name=null;
		while(enums.hasMoreElements()){
			name=enums.nextElement();
			map.put(name,request.getParameter(name));
//			System.out.println(name);
		}
		
		//将上传文件存到服务器路径下
		Files files = su.getFiles();
		String path = null;//文件保存路径
		String fileName =null;//文件名
		String temp="";
		String filedName = null;
		
		if(files!=null && files.getCount()>0){//说明用户文件已传上来
			Collection<File> collection = files.getCollection();
			path=servletConfig.getServletContext().getRealPath("/") + PATH;
//			System.out.println(path);
			
			java.io.File f = new java.io.File(path);
			if(!f.exists()){
				f.mkdir();//如果不存在则创
			}
			
			for(File f1:collection){//循环取出每一个上传文件
				if(!f1.isMissing()){//文件没有丢失
					filedName = f1.getFieldName();
					fileName = new Date().getTime()+"_"+new Random().nextInt(10000)+"."+f1.getFileExt();
//					System.out.println(fileName);
					//保存数据到指定文件
					f1.saveAs(path+"/"+fileName);
					
					if(!"".equals(temp)){
						temp+=",";
					}
					temp+=PATH+"/"+fileName;
				}
			}
			map.put(filedName, temp);
		}
//		System.out.println(map);
		return map;
	}
	
	
	public Map<String,String> uploadFromForm(ServletConfig servletConfig, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{
		Map<String,String> map = new HashMap<String, String>();
		//实例化一个SmartUpload对象
		SmartUpload su = new SmartUpload();//文件上传包的使用
		//初始化SmartUpload
		su.initialize(servletConfig, httpServletRequest, httpServletResponse);
		//设置参数
		su.setCharset("utf-8");
		
		//开始上传
		su.upload();
		//获取转换后的请求
		Request request = su.getRequest();
		Enumeration<String> enums = request.getParameterNames();//使用集合来装获取所有普通表单元素名
		
		//循环取出每一个表单元素名已对一的值 村到map中
		String name=null;
		while(enums.hasMoreElements()){
			name=enums.nextElement();
			map.put(name,request.getParameter(name));
//			System.out.println(name);
		}
		
//		System.out.println(map);
		return map;
	}


}
