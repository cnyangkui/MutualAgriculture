package com.geowind.hunong.aiplanning;

import com.geowind.hunong.jpa.Aiplan;
import com.geowind.hunong.jpa.AiplanDAO;
import com.geowind.hunong.jpa.EntityManagerHelper;
import com.geowind.hunong.util.WeatherDataCrawler;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class EffectByWeather {

	
	/**
	 * 将天气属性的值添加进AiPlan表中
	 */
	private void addWeatherInAiplan() {
		JsonArray jsonArray = readWeatherJson();
		AiplanDAO aiplanDAO = new AiplanDAO();
        for(int i=0; i<jsonArray.size(); i++) {
        	String item = jsonArray.get(i).toString();
        	JsonObject obj = new JsonParser().parse(item).getAsJsonObject();
        	String date = obj.get("date").getAsString();
        	String weather = obj.get("w1").getAsString();
        	if(!"".equals(weather)) {
        		Aiplan ai = aiplanDAO.findById(Integer.parseInt(date));
        		if(ai != null) {
        			ai.setWeather(weather);
        			EntityManagerHelper.beginTransaction();
        			try {
        				aiplanDAO.update(ai);
        				EntityManagerHelper.commit();
        			} catch (RuntimeException re) {
        				re.printStackTrace();
        			}
        		}
        	}
        }
	}
	
	/**
	 * 读取天气将Json字符串转为JsonArray数组
	 * @return
	 */
	private JsonArray readWeatherJson() {
		
		String weatherJson = new WeatherDataCrawler().getWeatherJson();
		//创建一个JsonParser
        JsonParser parser = new JsonParser();

        //通过JsonParser对象可以把json格式的字符串解析成一个JsonElement对象
        JsonElement el = parser.parse(weatherJson);

        //把JsonElement对象转换成JsonObject
        JsonObject jsonObj = null;
        if(el.isJsonObject()){
        	jsonObj = el.getAsJsonObject();  
        }
        //把JsonElement对象转换成JsonArray
        JsonArray jsonArray = null;
        if(el.isJsonArray()){
        	jsonArray = el.getAsJsonArray();
        }
        return jsonArray;
	}
	
	public static void main(String[] args) {
		new EffectByWeather().addWeatherInAiplan();
	}
}
