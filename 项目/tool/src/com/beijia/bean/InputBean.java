package com.beijia.bean;


/**
 * 前台输入信息Bean
 * */
public class InputBean {

	/** 文件存储路径 */
	private String filePath;
	/** DBMS
	 * ms: sqlserver2005
	 * my: mysql 
	 * or: oracle*/
	private String dbms;
	/** 数据库名 */
	private String databaseName;
	/** 表名 */
	private String tableName;
	/** 包名 */
	private String packagePath;
	/** 创建者 */
	private String creater;
	/** bean子路径 */
	private String beanChildPath;
	/** 当前日期 */
	private String dateNow;
	/** 当前时间 */
	private String datetimeNow;

	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getDbms() {
		return dbms;
	}
	public void setDbms(String dbms) {
		this.dbms = dbms;
	}
	public String getDatabaseName() {
		return databaseName;
	}
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getPackagePath() {
		return packagePath;
	}
	public void setPackagePath(String packagePath) {
		this.packagePath = packagePath;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public String getBeanChildPath() {
		return beanChildPath;
	}
	public void setBeanChildPath(String beanChildPath) {
		this.beanChildPath = beanChildPath;
	}
	public String getDateNow() {
		return dateNow;
	}
	public void setDateNow(String dateNow) {
		this.dateNow = dateNow;
	}
	public String getDatetimeNow() {
		return datetimeNow;
	}
	public void setDatetimeNow(String datetimeNow) {
		this.datetimeNow = datetimeNow;
	}
}
