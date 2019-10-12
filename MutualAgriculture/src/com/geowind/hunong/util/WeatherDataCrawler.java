package com.geowind.hunong.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.Scanner;

/**
 * 爬取天气数据
 * @author Kui
 *
 */
public class WeatherDataCrawler {

	/**
	 * 爬取天气数据
	 * @return
	 */
	public String getWeatherJson() {
		
    	String weatherJson = null;
    	URL url;
		try {
			Calendar calendar = Calendar.getInstance(); 
			int month = calendar.get(Calendar.MONTH)+1;
			String mon = null;
			if(month < 10) {
				mon = "0"+String.valueOf(month);
			} else {
				mon = String.valueOf(month);
			}
			String year = String.valueOf(calendar.get(Calendar.YEAR));
			url = new URL("http://d1.weather.com.cn/calendar_new/"+year+"/101250401_"+year+mon+".html");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        con.setRequestMethod("GET");
	        con.setRequestProperty("Referer", "http://www.weather.com.cn/weather40d/101250401.shtml");
	        con.connect();
	        Scanner in  = new Scanner(con.getInputStream());
	        StringBuffer sb = new StringBuffer();
	        while (in.hasNextLine()) {
	        	sb.append(in.nextLine());
			}
	        String weatherInfo = sb.toString();
//	        System.out.println(weatherInfo);
	        int index = weatherInfo.indexOf("[");
	        weatherJson = weatherInfo.substring(index);
//	        System.out.println(weatherJson);
	        in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return weatherJson;
		
    }
}
