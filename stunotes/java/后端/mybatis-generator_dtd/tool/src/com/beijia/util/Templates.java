package com.beijia.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 模版文件操作类
 * */
public class Templates {

	/**
	 * 获取所有模板文件的文件名
	 * */
	public static String[] fileList(){
		return new File("templates/").list();
	}
	
	/**
	 * 读取模板文件
	 * */
	public static String getTemplate(String fileName){
		if(!fileName.startsWith("templates")){
			fileName = "templates/" + fileName;
		}
		BufferedReader bf = null;
		StringBuilder fileContext = new StringBuilder("");
		try {
			bf = new BufferedReader(
					new FileReader(fileName));
			String value = null;
			while((value=bf.readLine())!=null){
				fileContext.append(value);
				fileContext.append("\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bf!=null){
				try {
					bf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return fileContext.toString();
	}
	
	/**
	 * 生成文件，并输出到指定目录
	 * */
	public static void generateProduct(String content, String path, String fileName){
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(
					new FileWriter(path + fileName));
			if(fileName.contains("xml")){
				bw.write(content);
			}else{
				bw.write(new String(content));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bw != null){
				try {
					bw.flush();
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
