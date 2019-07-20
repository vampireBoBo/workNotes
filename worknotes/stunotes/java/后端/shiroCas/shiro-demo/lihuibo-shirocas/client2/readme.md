注意！！!
1、client2的项目是通过simple maven项目后期转变成web项目  故在动态发布时 需要添加maven的依赖库 否则部署时 项目不会是一个web项目，即没有spring-web的jar
2、动态添加的maven依赖 若对项目进行maven update后，该依赖需要再次手动添加

3、日志
	使用slf4j log4j2
	日志学习链接：https://my.oschina.net/xianggao/blog/523401   				 				 				        				https://blog.csdn.net/vbirdbest/article/details/71751835【重要】
	使用步骤
	1.pom添加jar
	2.配置log4j2.xml文件
	3.如果配置文件的位置不是src/main/resources的根目录，则需要在web.xml中进行指定 并配置对应的监听。反之不需要，直接进行测试使用即可。
	4.web的配置：
		<context-param>  
		    <param-name>log4jConfiguration</param-name>  
		    <param-value>classpath:spring/log4j2.xml</param-value>  
		</context-param>  
		<listener>  
		    <listener-class>org.apache.logging.log4j.web.Log4jServletContextListener</listener-class>  
		</listener>
		此处监听的配置不能少  负责 任然识别不到配置文件的路径
		

