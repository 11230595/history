package com.yiyong.framework.core.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;
/**
 * 解决spring mvc 日期返回long值的问题
 * @author zhoudong
 *
 */
public class DateObjectMapper extends ObjectMapper {
	 public DateObjectMapper() {
		 CustomSerializerFactory factory = new CustomSerializerFactory();  
	        factory.addGenericMapping(Date.class, new JsonSerializer<Date>(){  
	            @Override  
	            public void serialize(Date value,   
	                    JsonGenerator jsonGenerator,   
	                    SerializerProvider provider)  
	                    throws IOException, JsonProcessingException {  
	                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	                jsonGenerator.writeString(sdf.format(value));  
	            }  
	        });  
	        setSerializerFactory(factory);  
	    }
}
