package com.example.demo.entity;

import java.io.Serializable;


/**
 * 
 * 描述:<br>
 *--------------------------------------------------------------<br>
 * V1.0 创建  lhb 2018-07-09  新项目 <br>
 *--------------------------------------------------------------<br>
 */
public class Dept implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3134239364062040893L;

	private String id;
	
	private String no;
	
	private String name;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
