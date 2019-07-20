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

4、集成cas

	A、添加jar
		<dependency>
		    <groupId>org.apache.shiro</groupId>
		    <artifactId>shiro-cas</artifactId>
		    <version>1.4.0</version>
		</dependency>
		
	B、重新casRealm 连接本地数据库  进行用户权限和角色的获取
		com.lhb.realm.MyCasRealm
		
	C、配置shiro-cas所需参数的配置文件
		/client2/src/main/resources/properties/shiro-cas.properties
		
	D、配置shiro-cas.xml文件 并将其引入spring的配置文件中使其在web容器中初始化
		<!-- 引入shiro-cas的配置文件 -->
    		<import resource="shiro-cas.xml"/>
    		
    	E、启动项目 进行测试访问  下一步进行ehcache缓存的集成 用于提高数据的访问速率
    	
    	F、配置ehcache
    		添加jar包
	    		<dependency>
		        <groupId>org.apache.shiro</groupId>
		        <artifactId>shiro-ehcache</artifactId>
		        <version>${shiro.version}</version>
		    	</dependency>
		 添加ehcahe的配置文件
		 	/client2/src/main/resources/spring/ehcache-shiro.xml
		 托管缓存 并配置到shiro安全管理器中 securityManager
		 	
		
	
		

