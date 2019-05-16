package com.techoffice.security.util;

import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	private static Log log = LogFactory.getLog(JsonUtil.class);
	
	private JsonUtil(){}
	
	public static <T> T getObject(String jsonStr, Class<T> clazz){
		ObjectMapper objectMapper = new ObjectMapper();
		try{
			T object = objectMapper.readValue(jsonStr, clazz);	
			return object;
		}catch(Exception e){
			log.error(e.getMessage(), e);
		}
		return null;
	}
	
	public static <T> T getObject(InputStream inputStream, Class<T> clazz){
		ObjectMapper objectMapper = new ObjectMapper();
		try{
			T object = objectMapper.readValue(inputStream, clazz);	
			return object;
		}catch(Exception e){
//			log.error(e.getMessage(), e);
		}
		return null;
	}
}
