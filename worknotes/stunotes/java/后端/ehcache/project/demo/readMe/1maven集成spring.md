maven项目集成spring
================================================
1、pom添加依赖
	<dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>${spring.version}</version>
    </dependency>
	
	spring-context:包含spring-core、spring-beans、spring-aop、spring-expression 所以spring的控制反转（IOC） 依赖注入（DI）功能基本够用了
	
	
	注意！！！======【如果项目为web项目  则需要在listern中开启spring的监听去初始化 spring容器  否则启动时报错java.lang.ClassNotFoundException: org.springframework.web.context.ContextLoaderListener】
	
	 <dependency>
         <groupId>org.springframework</groupId>
         <artifactId>spring-web</artifactId>
         <version>${spring.version}</version>
    </dependency>
	
2、配置applicationContext.xml文件
	<?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://www.springframework.org/schema/beans"
		   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		   xmlns:context="http://www.springframework.org/schema/context"
		   xsi:schemaLocation="http://www.springframework.org/schema/beans
		   					   http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
		   					   http://www.springframework.org/schema/context
		   					   http://www.springframework.org/schema/context/spring-context-3.0.xsd">
		<!-- 扫描基础包 -->
		<context:component-scan base-package="com.lhb.service" />
		<!-- 开启注解 实现spring控制反转  依赖注入  -->
		<context:annotation-config/>
	</beans>
	
	此处将通过以注解的方式进行类的控制反转和依赖注入：进行基础包的扫描   开启注解功能
	
3、编写两个不同的service类并进行类之间的相互访问
	IStudentService -- StudentServiceImpl
	ITeacherService -- TeacherServiceImpl
	
	此处不进行持久层测试故不需要编写Dao Mapper，故在StudentServiceImpl调用TeacherServiceImpl中的方法  即需要测试属性类接口的调用  即依赖注入功能
	