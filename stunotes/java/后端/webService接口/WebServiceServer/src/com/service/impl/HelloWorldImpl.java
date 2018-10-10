package com.service.impl;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.service.IHelloWorld;

/**
 * 外放的webservice接口的实现类
 * @author Administrator
 * webservice表示该类为一个wx类，
 * 参数endpointInterface表示该类对外的接口类，
 * serviceName表示对外的服务名该参数可有可无,
 * 
 * targetNamespace该参数的值要为申明接口的包路径需要倒着写，
 * 通过wsdl文件看到申请接口和接口实现类的namespace要保持一致，
 * 否则通过JaxWsDynamicClientFactory调用时会提示找不到服务
 */
@WebService(endpointInterface="com.service.IHelloWorld",serviceName="Hello",targetNamespace="http://service.com/")
public class HelloWorldImpl implements IHelloWorld {

	@Override
	public String sayHi(@WebParam(name="hiString") String hiString) {
		return "该方法为sayHi:"+hiString;
	}

	@Override
	public String sayHello(String helloString) {
		return "该方法为sayHello:"+helloString;
	}

}
