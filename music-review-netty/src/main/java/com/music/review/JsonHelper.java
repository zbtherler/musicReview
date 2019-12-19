package com.music.review;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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


	public static String createPaySign(Map<String, Object> signParamMap, String appsecret) {
		//签名
		List<String> paramList = new ArrayList<String>(signParamMap.keySet());
		String [] keyArr = new String[paramList.size()];
		keyArr = paramList.toArray(keyArr);
		Arrays.sort(keyArr);

		StringBuffer buffer = new StringBuffer();
		for (String key1 : keyArr) {
			if(null != signParamMap.get(key1)){
				buffer.append(key1+"="+signParamMap.get(key1)+"&");
			}
		}
		buffer.append("key=" +appsecret);
		System.out.println(buffer.toString());
		String sign = MD5Util.MD5Encode(buffer.toString(), "UTF-8").toUpperCase();
		System.out.println("sign:"+sign);
		return sign;
	}
	
	public static void main(String[] args) {
	}
}
