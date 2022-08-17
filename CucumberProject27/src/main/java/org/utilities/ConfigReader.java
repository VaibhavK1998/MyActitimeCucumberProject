package org.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	FileInputStream fis;
	Properties prop;
	public String getConfigtestdata(String key) {
			try{
				fis = new FileInputStream("./src/test/resources/propertiesFiles/config.properties");//step 1
			  	prop=new Properties();
				prop.load(fis); 
			}catch(IOException e) {
				e.printStackTrace();
			} 
		  
			return prop.getProperty(key);// it will return the value of this key
	}
	
	public Properties initprop() { 
		try{
			fis = new FileInputStream("./src/test/resources/propertiesFiles/config.properties");//step 1
		  	prop=new Properties();
			prop.load(fis); 
		}catch(IOException e) {
			e.printStackTrace();
		} 
	
		return prop;// //it will return the object of properties class
	}
}
