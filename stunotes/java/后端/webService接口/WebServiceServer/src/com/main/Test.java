package com.main;



import javax.xml.ws.Endpoint;

import com.service.impl.HelloWorldImpl;

/**
 * 该类为测试类  手动发布外发的webservice接口
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
		Endpoint.publish("http://127.0.0.1:8080/hello", new HelloWorldImpl());
		System.out.println("发布成功！");
		// 发布成功以后使用在浏览器中输入http://127.0.0.1:8080/hello?wsdl 进行校验，是否显示xml格式文件
	}
}
