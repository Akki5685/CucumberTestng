package com.DataConfig;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.Enums.BrowserType;
import com.Enums.ExecutionType;

public class ReadConfig {
	private final   Properties properties;
    /**
     * Method to read config file values     */

    public ReadConfig(){
        BufferedReader bufferedReader;
        FileReader fileReader;
        String strPropertyPath="config/configuration.properties";
        try {
            fileReader = new FileReader(strPropertyPath);
            bufferedReader = new BufferedReader(fileReader);
            properties = new Properties();
            try {
                properties.load(bufferedReader);
                bufferedReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
                throw new RuntimeException("Config file not found at"+strPropertyPath);
            }

        }
        /**
         * method to get the application url value from property file
         * @return application url
         */

        public String getApplicationURL(){
            String strAppURL=properties.getProperty("Environment");
          strAppURL="https://"+strAppURL+":/";//https://admin-demo.nopcommerce.com/login   https://www.amazon.in/

            if(strAppURL !=null){
                return strAppURL;
            }
            else {
                throw new RuntimeException("Application URL is not present in the config property");
            }
        }

    /**
     * method to get the wait time value from the config file
     * @return wait time
     */
    public long getWaitTime(){
        String strWaitTime=properties.getProperty("WaitTime");
        if(strWaitTime !=null){
            return Long.parseLong(strWaitTime);
        }
        else{
            throw new RuntimeException("Application URL is not present in the config property");
        }
    }
    /** method to get browser value from property file
     * @return type of browser
     */

    public BrowserType getBrowser(){
        String strBrowser=properties.getProperty("Browser");
        switch (strBrowser){
            case "chrome":
                return BrowserType.CHROME;
            case "edge":
                return BrowserType.EDGE;
            case "firefox":
                return BrowserType.FIREFOX;
            case "safari":
                return BrowserType.SAFARI;
            default:
                throw new RuntimeException("Browser is not present in the config property");
        }
    }
    /**
     * method to get the execution type value from the property file
     * @return ty[pe of execution
     */
    public ExecutionType getExecutionType(){
        String strExecutionType=properties.getProperty("ExecutionType");
        switch (strExecutionType){
            case "local":
                return ExecutionType.LOCAL;
            case "remote":
                return ExecutionType.REMOTE;
            default:
                throw new RuntimeException("ExeceutionType is not present in the config property");
        }
    }
}
