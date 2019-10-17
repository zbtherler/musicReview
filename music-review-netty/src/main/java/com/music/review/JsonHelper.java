package com.music.review;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonHelper {

//	private static Gson gson = new GsonBuilder().disableHtmlEscaping().create();
	private static Gson gson = new GsonBuilder().create();
	private static Gson annotationsGson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

	public static <T> T fromJson(String json, Class<T> clazz) {
		try {
			return gson.fromJson(json.toString(), clazz);
		} catch (Exception e) {
		}
		return null;
	}
	
	public static <T> T fromJson(String json, Type type) {
		try {
			return gson.fromJson(json, type);
		} catch (Exception e) {
//			System.out.println(" error json : "+json);
//			e.printStackTrace();
		}
		return null;
	}

	public static String toJson(Object ... obj) {
		if(obj == null || obj.length == 0) return null;
		
		if(obj.length == 1){
			return gson.toJson(obj[0]);
		}
		//将多个值合并为一个集合返回
		List<Object> list = new ArrayList<Object>();
		for (int i = 0; i < obj.length; i++) {
			list.add(obj[i]);
		}
		return gson.toJson(list);
	}
	
	/**
	 * 将对象注解指定字段的转为json字符串
	 * @param obj
	 * @return
	 * @throws
	 */
	public static String toJsonIgnore(Object obj) {
		try {
			return annotationsGson.toJson(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
	}
}
