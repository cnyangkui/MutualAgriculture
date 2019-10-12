package com.geowind.hunong.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.geowind.hunong.util.TimerManager;

public class WeatherDataTaskListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
        new TimerManager();
   }

   public void contextDestroyed(ServletContextEvent sce) {
       // TODO Auto-generated method stub
        
   }
}
