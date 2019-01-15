package com.beijia.view;

import java.util.Date;

import com.beijia.bean.InputBean;
import com.beijia.service.DataAccess;
import com.beijia.util.DateFormat;

public class View {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InputBean input = new InputBean();
		//创建人
		input.setCreater("admin");
		//保存路径
		input.setFilePath("F:/mapper");
		//表名
		input.setTableName("dispose_vpn_apply");
		//包名
		input.setPackagePath("com.future");
		//Bean包名
		input.setBeanChildPath("entity");
		//对应数据库，从dbDatabase.properties中获得
		input.setDatabaseName("db2");
		//数据库管理系统，dbconfig.properties中对应配置的前缀
		input.setDbms("ms");
		//当前日期
		input.setDateNow(DateFormat.getDateFormatStr(new Date()));
		//当前时间（可选）
		input.setDatetimeNow(DateFormat.getDatetimeFormatStr(new Date()));
		DataAccess da = new DataAccess(input);
		da.dataAccess();
	}

}
