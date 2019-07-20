package com.lhb.util;

import java.io.Serializable;

public class Result implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String SUCCESS = "执行成功";
	
	private static final String FAILURE = "执行失败";
	
	private Integer code;
	
	private String msg;
	
	private Object obj;

	public Result(int code,String msg){
		this(code,msg,null);
	}
	
	public Result(Integer code, String msg, Object obj) {
		this.code = code;
		this.msg = msg;
		this.obj = obj;
	}
	// 成功
	public static Result SUCCESS(Object obj){
		return new Result(200,SUCCESS,obj);
	}
	public static Result SUCCESS(String msg,Object obj){
		return new Result(200,msg,obj);
	}
	// 失败
	public static Result FAILURE(){
		return new Result(405,FAILURE);
	}
	public static Result FAILURE(String msg){
		return new Result(405,msg);
	}
	public static Result FAILURE(int code,String msg){
		return new Result(code,msg);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	
}
