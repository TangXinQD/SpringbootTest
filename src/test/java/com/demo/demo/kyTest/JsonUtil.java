package com.demo.demo.kyTest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


public class JsonUtil {
	/**
	 * javaBean和集合 转换成json字符串
	 * @param obj
	 * @return
	 */
	public static String objectToJson(Object obj){
		ObjectMapper mapper = new ObjectMapper();
        
        //User类转JSON  
        //输出结果：{"name":"小民","age":20,"birthday":844099200000,"email":"xiaomin@sina.com"}  
        String json = "";
		try {
			json = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return json;
	}
	
	/**
	 * 将json字符串转换为java对象
	 * @param jsonStr
	 * @param clazz
	 * @return
	 */
	public static <T> T jsonStrToObject(String jsonStr,Class<T> clazz){
		if(null == jsonStr || "".equals(jsonStr)){
			return null;
		}
		T obj = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			obj = mapper.readValue(jsonStr, clazz);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return obj;
	}
	
}
