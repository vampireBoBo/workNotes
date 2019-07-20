package com.beijia.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期处理工具
 * */
public class DateFormat {
	
	/**
	 * 将Date对象转换为精确到天的日期字符串
	 * */
	public static String getDateFormatStr(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	/**
	 * 将Date对象转换为精确到秒的时间字符串
	 * */
	public static String getDatetimeFormatStr(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
}
