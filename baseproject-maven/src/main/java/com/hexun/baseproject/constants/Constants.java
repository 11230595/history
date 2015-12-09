package com.hexun.baseproject.constants;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;
/**
 * 常亮及配置文件读取
 * 配置文件会读取到内存中
 * @author zhoudong
 *
 */
public class Constants {

	public static Configuration config =null;
 	static{
 		
		try {
			config= new PropertiesConfiguration("config.properties");
		}catch(Exception e){
			e.printStackTrace();
		}
 	}
}
