package com.beijia.service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.beijia.bean.ColumnBean;
import com.beijia.bean.DatabaseBean;
import com.beijia.bean.InputBean;
import com.beijia.bean.TableBean;
import com.beijia.mapper.BaseDao;
import com.beijia.util.LetterUtil;
import com.beijia.util.PropAnalysis;
import com.beijia.util.Templates;

/**
 * 数据中心类：
 * 		1、从view拿到数据；
 * 		2、调用BaseDao；
 * 		3、调用模版处理类进行模板加工；
 * 		4、调用工具类处理路径等数据
 * 		5、调用工具类输出模版
 * */
public class DataAccess {
	
	/** 模版集合<文件名,文件内容> */
	private Map<String,String> temps;
	/** 文件集合<模板名,文件名> */
	private Map<String,String> fileNames;
	/** 参数集合 */
	private Map<String,String> parameters;
	
	/** 获取到的表数据 */
	private TableBean tb;
	/** 文件信息获取类 */
	private TempGenerator tg;
	/** 前台输入信息 */
//	private InputBean ib;
	
	private static Set<String> iterItems;
	static{
		iterItems = new HashSet<String>();
		Map<String,String> map = PropAnalysis.convertPropToMap("parameter.properties");
		for (String key : map.keySet()) {
			if(key.startsWith("iterator")){
				iterItems.add(key);
			}
		}
	}
	
	public DataAccess(InputBean input){
//		this.ib = input;
		tb = BaseDao.getMetaData(input.getTableName(), this.getDatabase(input));
		tg = new TempGenerator(tb, input);
		//获取指定数据库的指定表信息
		String[] files = Templates.fileList();
		temps = new HashMap<String,String>();
		for (int i = 0; i < files.length; i++) {
			temps.put(files[i],Templates.getTemplate(files[i]));
		}
	}
	
	/**
	 * 数据处理核心方法
	 * */
	public void dataAccess(){
		generateFileName();
		try {
			generateFileContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库链接参数
	 * */
	private DatabaseBean getDatabase(InputBean input){
		DatabaseBean db = new DatabaseBean();
		//设置数据库名称
		db.setDatabase(PropAnalysis.getProp("dbDatabase.properties", input.getDatabaseName()));
		//拿到数据库管理系统代号
		String dbHead = input.getDbms();
		db.setClassName(PropAnalysis.getProp("dbconfig.properties", dbHead+"className"));
		db.setUri(PropAnalysis.getProp("dbconfig.properties", dbHead+"uri"));
		db.setUserName(PropAnalysis.getProp("dbconfig.properties", dbHead+"userName"));
		db.setPassWord(PropAnalysis.getProp("dbconfig.properties", dbHead+"passWord"));
		return db;
	}
	
	/**
	 * 根据模版名，生成对应的文件名
	 * */
	private void generateFileName(){
		Set<String> tempNames = temps.keySet();
		fileNames = new HashMap<String,String>();
		for (String tempName : tempNames) {
			String[] temp = tempName.split("~");
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < temp.length; i++) {
				if(temp[i].contains("TableName")){
					temp[i] = tb.getTableName();
				}
				sb.append(temp[i]);
			}
			fileNames.put(tempName,sb.toString());
		}
	}
	
	/**
	 * 根据模板内容，生成对应文件内容
	 * @throws  
	 * @throws Exception 
	 * */
	private void generateFileContent() throws Exception{
		Iterator<String> it = temps.keySet().iterator();
		parameters = PropAnalysis.convertPropToMap("parameter.properties");
		//每个循环，处理一个模板
		while(it.hasNext()){
			String tempName = it.next();
			if(tempName.startsWith("vssver2.scc")){
				continue;
			}
			String tempCont = temps.get(tempName);
			//fileCont保存了处理后的模板内容
			String fileCont = "";
			if(tempCont.indexOf("~!iterator!~") > -1){
				//如果含有迭代器，用迭代方法处理
				tempCont = iteratorAccess(tempCont);
			}
			fileCont = commonAccess(tempCont,0);
			//生成成品文件
			//处理存储路径
			String[] contArr = fileCont.split("-{5,}head-{5,}");
			String childPath = contArr[0];
			fileCont = contArr[1].replaceFirst("\n", "");
			Templates.generateProduct(fileCont, tg.getFilePath(childPath), fileNames.get(tempName));
		}
	}
	
	/**
	 * 处理迭代标记的方法
	 * */
	private String iteratorAccess(String tempCont) throws Exception {
		StringBuilder content = new StringBuilder();
		List<String> fileCont = new ArrayList<String>();
		List<String> forIter = new ArrayList<String>();
		//获取
		String[] slices = LetterUtil.slice(tempCont, "~!iterator!~", "~!!iterator!~");
		for (int i = 0; i < slices.length; i++) {
			if(i%2 != 0){
				forIter.add(slices[i]);
			}
		}
		//处理循环体
		List<ColumnBean> cols = tb.getColumns();
		for (int i = 0; i < forIter.size(); i++) {
			String subCont = forIter.get(i);
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < cols.size(); j++) {
				sb.append(commonAccess(subCont,j));
			}
			fileCont.add(sb.toString());
		}
		//拼接
		for (int i = 0,j=0; i < slices.length; i++) {
			if(i%2 != 0){
				slices[i] = fileCont.get(j);
				j++;
			}
			content.append(slices[i]);
		}
		return content.toString();
	}

	/**
	 * 通过反射为模版获取信息
	 * */
	private String commonAccess(String tempCont, int colNum) throws Exception{
		StringBuilder fileCont = new StringBuilder();
		String[] contArr = tempCont.split("~");
		for (int i = 0; i < contArr.length; i++) {
			if(i%2 != 0){
				if(parameters.containsKey(contArr[i])){
					if(iterItems.contains(contArr[i])){
						//调用循环，传入i
						String methodName = parameters.get(contArr[i]);
						Method method = tg.getClass().getMethod(methodName,int.class);
						Object obj = method.invoke(tg,colNum);
						if (obj!=null) {
							contArr[i] = obj.toString();
						}
					}else{
						//反射调用对应的方法
						Method method = tg.getClass().getMethod(parameters.get(contArr[i]));
						contArr[i] = method.invoke(tg).toString();	
					}
				}
			}
			fileCont.append(contArr[i]);
		}
		return fileCont.toString();
	}
}
