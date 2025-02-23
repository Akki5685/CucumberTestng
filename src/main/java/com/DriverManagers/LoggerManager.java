package com.DriverManagers;

import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
public class LoggerManager {
	 private static  boolean root=false;

	    public static Logger getLogger(Class cls){
	        if(root){
	            return Logger.getLogger(cls);
	        }
	        PropertyConfigurator.configure("Log4j.properties");
	        root=true;
	        return Logger.getLogger(cls);
	    }
	    public static void main(String[] args){
	        Logger log = LoggerManager.getLogger(LoggerManager.class);
	        log.info("log main class");
	    }

}
