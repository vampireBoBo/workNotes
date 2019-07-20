package com.beijia.bean;

/**
 * 描述列的Bean
 * */
public class ColumnBean {
	
	/**列名*/
	private String colName;
	/**列类型*/
	private String colType;
	/**列长度*/
	private int dataSize;
	/**小数位数*/
	private int digits;
	/**
	 * 是否可以为空
	 * 1 表示可以为null
	 * 0 表示不能为null
	 * */
	private int nullable;
	
	public String getColName() {
		return colName;
	}
	public void setColName(String colName) {
		this.colName = colName;
	}
	public String getColType() {
		return colType;
	}
	public void setColType(String colType) {
		this.colType = colType;
	}
	public int getDataSize() {
		return dataSize;
	}
	public void setDataSize(int dataSize) {
		this.dataSize = dataSize;
	}
	public int getDigits() {
		return digits;
	}
	public void setDigits(int digits) {
		this.digits = digits;
	}
	public int getNullable() {
		return nullable;
	}
	public void setNullable(int nullable) {
		this.nullable = nullable;
	}
}
