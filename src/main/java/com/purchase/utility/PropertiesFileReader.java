package com.purchase.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {
	
	public Properties getProperty() throws IOException {

		FileInputStream inputStream = null;
		Properties properties = new Properties();
		
		try {
			
			String mysysprojectpath = System.getProperty("user.dir");
			properties.load(new FileInputStream(mysysprojectpath + "\\src\\main\\java\\resources\\configfile\\browser-config.properties"));
		
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return properties;
	}

}
