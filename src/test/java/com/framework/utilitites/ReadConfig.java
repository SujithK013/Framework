package com.framework.utilitites;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {

		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exceptio is" + e.getMessage());
		}
	}

	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUserName() {
		String username = pro.getProperty("username");
		return username;
	}
	
	public String getPassword() {
		String pswrd = pro.getProperty("password");
		return pswrd;
	}
	
	public String getChromePath() {
		String chrmpath = pro.getProperty("chromepath");
		return chrmpath;
	}
	
	public String getiePath() {
		String iepath = pro.getProperty("iepath");
		return iepath;
	}
	
	public String getfirePath() {
		String firepath = pro.getProperty("firepath");
		return firepath;
	}

}
