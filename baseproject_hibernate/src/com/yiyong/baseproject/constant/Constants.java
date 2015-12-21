package com.yiyong.baseproject.constant;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class Constants {
	public static Configuration config =null;
 	static{
 		
		try {
			config= new PropertiesConfiguration("config.properties");
 		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}
 	/**
 	 * 删除标记
 	 */
	public static int DEL_FLAG = 1 ;
	/**
	 * 未删除标记
	 */
	public static int UN_DEL_FLAG = 0 ;
}
