package com.lhb.util;
/**
 * <p>Titile: 接口公用返回类</p>
 * <p>Description: 用于规范不同接口返回值信息的类</p>
 * @user Administrator
 * @data 2019年1月28日
 */
public class Result {
	private static final String SUCCESS = "操作成功";
	
	private static final String FAILURE = "操作失败";
	
	private String msg;
	
	private int code;
	
	private Object obj;

	/**
	 * @param msg
	 * @param code
	 * @param obj
	 */
	public Result(String msg, int code, Object obj) {
		super();
		this.msg = msg;
		this.code = code;
		this.obj = obj;
	}

	/**
	 * @param msg
	 * @param code
	 */
	public Result(String msg, int code) {
		super();
		this.msg = msg;
		this.code = code;
	}
	
	public static Result SUCCESS(){
		return new Result(SUCCESS,200);
	}

	public static Result SUCCESS(Object obj){
		return new Result(SUCCESS,200,obj);
	}
	
	public static Result SUCCESS(String msg,int code,Object obj){
		return new Result(msg,code,obj);
	}
	
	public static Result FAILURE(){
		return new Result(FAILURE,500);
	}
	
	public static Result FAILURE(String msg,int code){
		return new Result(msg,code);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public static String getSuccess() {
		return SUCCESS;
	}

	public static String getFailure() {
		return FAILURE;
	}
	
}
