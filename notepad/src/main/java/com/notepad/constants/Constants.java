package com.notepad.constants;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;

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
