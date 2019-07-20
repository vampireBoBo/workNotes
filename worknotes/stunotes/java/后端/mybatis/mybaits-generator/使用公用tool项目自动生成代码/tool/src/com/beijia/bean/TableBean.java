package com.beijia.bean;

import java.util.List;

/**
 * 表述表的Bean
 * */
public class TableBean {
	
	/**所属库名*/
	private String dbName;
	/**所属域名*/
	private String domainName;
	/**表名*/
	private String tableName;
	/**字段集合*/
	private List<ColumnBean> columns;
	
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public List<ColumnBean> getColumns() {
		return columns;
	}
	public void setColumns(List<ColumnBean> columns) {
		this.columns = columns;
	}
}
