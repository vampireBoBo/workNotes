package com.beijia.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

/**
 * 解析Properties文件
 * */
public class PropAnalysis {

	private static Properties prop;
	private static String propName = "";

	/**
	 * 根据Key获取对应的value
	 * @throws IOException 
	 * */
	public static String getProp(String propName,String key) {
		if(!PropAnalysis.propName.equals(propName) || 
				prop == null || prop.size() == 0){
			getCache(propName);
		}
		return prop.getProperty(key);
	}
	
	/**
	 * 把指定properties文件转换成map并返回
	 * */
	public static Map<String,String> convertPropToMap(String propName){
		Map<String,String> map = new HashMap<String, String>();
		getCache(propName);
		for (Entry<Object, Object> propElement : prop.entrySet()) {
			map.put(propElement.getKey().toString(), propElement.getValue().toString());
		}
		return map;
	}
	
	private static void getCache(String propName){
		prop = new Properties();
		PropAnalysis.propName = propName;
		InputStream in = PropAnalysis.class.getResourceAsStream(
				propName);
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
