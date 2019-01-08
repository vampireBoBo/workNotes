package com.beijia.service;

import java.io.File;
import java.util.Date;

import com.beijia.bean.InputBean;
import com.beijia.bean.TableBean;
import com.beijia.util.DateFormat;
import com.beijia.util.LetterUtil;
import com.beijia.util.PropAnalysis;

/**
 * 模版生成工具
 * */
public class TempGenerator {

	private TableBean tb;
	private InputBean ib;
	
	public TempGenerator(TableBean tb,InputBean ib){
		this.ib = ib;
		this.tb = tb;
	}
	
	public String getPackagePath(){
		return ib.getPackagePath();
	}
	public String getBeanPath(){
		return ib.getBeanChildPath();
	}
	public String getFilePath(String filePackage){
		String filePath = ib.getFilePath();
		if(filePath.charAt(filePath.length()-1) != '/'){
			filePath += "/";
		}
		String[] pPathArr = filePackage.split("\\.");
		String path = "";
		for (int i = 0; i < pPathArr.length; i++) {
			path += pPathArr[i];
			path += "/";
		}
		String finalPath = filePath + path;
		finalPath = finalPath.replaceAll("\n", "");
		finalPath = finalPath.replaceAll("\r", "");
		File file = new File(finalPath);
		if(!file.exists()){
			file.mkdirs();
		}
		return finalPath;
	}
	public String gettableName(){
		return LetterUtil.toLowerCaseFirstOne(tb.getTableName());
	}
	public String getTableName(){
		return LetterUtil.toUpperCaseFirstOne(tb.getTableName());
	}
	public String getCreater(){
		return ib.getCreater();
	}
	public String getDateNow(){
		return DateFormat.getDateFormatStr(new Date());
	}
	public String getDatetimeNow(){
		return DateFormat.getDatetimeFormatStr(new Date());
	}
	public String getType(int i){
		String key = tb.getColumns().get(i).getColType();
		return PropAnalysis.getProp("type.properties", key);
	}
	public String getcolumnName(int i){
		return LetterUtil.toLowerCaseFirstOne(tb.getColumns().get(i).getColName());
	}
	public String getColumnName(int i){
		return LetterUtil.toUpperCaseFirstOne(tb.getColumns().get(i).getColName());
	}
}
