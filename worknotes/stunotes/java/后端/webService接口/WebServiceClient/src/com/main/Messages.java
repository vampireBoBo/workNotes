package com.main;

import java.net.URL;
import java.util.Properties;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import com.service.IHelloWorld;


/**
 * 调用webservice提供的接口
 * @author Administrator
 * 访问方式1与方式2的区别：
 * 	【
 *  方式1在进行请求时，设置的method参数即为接口中对应的方法名称。
 * 	方式2在进行请求时设置的qname中的第二个参数为ws实现类中设置的服务名，通过wsdl可进行查看。因为参数1为实现类的namespace，所以并不确定访问的服务是哪个，则需要用服务名来判断访问的具体是该包下的哪个类。
 *  namespace是根据接口包的路径反向生成的。
 *  】
 *   
 *  【
 *  方式1中若接口实现类和接口类的namespace不一致时请求报错提示找不到方法，方式2则不受namespace的影响。
 *  】
 *  
 *  【
 *  方式一和方式二在请求中均需要对应的cxf的jar包，而方式二中还需要ws中对应的接口类（不是接口实现类）jar包。
 *  】
 */
public class Messages {
	public static void main(String[] args) {
		try {
			/**
			 * 访问方法1：
			 */
			/*// 使用url查看wsdl的xml格式文件是否可以显示 若显示表示服务有提供者  否则相反
			JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
			// 设置服务访问url和对应的接口名称
			String wsdlUrl = "http://127.0.0.1:8080/hello?wsdl";
			String method= "sayHello";
			String params = "hello?我是客户端我在调用服务器端的ws接口";
			// 访问
			// 报错：Cannot create a secure XMLInputFactory  解决方法添加如下Properties三行代码
			Properties props = System.getProperties(); 
			props.setProperty("org.apache.cxf.stax.allowInsecureParser", "1"); 
			props.setProperty("UseSunHttpHandler", "true");
			Client client = dcf.createClient(wsdlUrl);
			Object[] obj = client.invoke(method, params);
			System.out.println("调用接口\n"+obj[0].toString());*/
			/**
			 * 访问方法2：
			 * 特点：该方法除了所需要cxf的jar包 还需要将服务器端外放ws类的接口进行jar提供，用于service进行wx操作类的获取
			 */
			// 创建wsdl的url
			URL url = new URL("http://127.0.0.1:8080/hello?wsdl");
			// 通过Qname指明服务的具体信息   通过wsdl文件查看targetNamespace="http://impl.service.com/" name="Hello"
			QName qname = new QName("http://service.com/", "Hello");
			Properties props = System.getProperties(); 
			props.setProperty("org.apache.cxf.stax.allowInsecureParser", "1"); 
			props.setProperty("UseSunHttpHandler", "true");
			// 创建服务
			Service service = Service.create(url, qname);
			// 实现接口
			IHelloWorld hello = service.getPort(IHelloWorld.class);
			String result = hello.sayHello("hello?我是客户端我在调用服务器端的ws接口");
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
