package com.service;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 外放的webservice接口的抽象类 
 * @author Administrator
 */
// 该注解用于表示该类为webservice的类
@WebService  
public interface IHelloWorld {
	// @WebParam(name="hiString")只是说明在wsdl中指明参数的名字是hiString
	String sayHi(@WebParam(name="hiString") String hiString);
	String sayHello(String helloString);
}
