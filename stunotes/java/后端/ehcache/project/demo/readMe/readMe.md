1、创建maven项目
2、整合spring：https://www.cnblogs.com/crazybirds/p/4643497.html
	spring：核心作用IOC依赖注入、aop面向切面编程
	ssm：view层/控制层 （jsp controller 属于===》 springmvc模块）+ 业务层（service属于===》spring模块） + 持久层（Dao mapper属于===》mybatis模块）
	关键：通过applicationContext.xml进行基础包的扫描，实现依赖注入功能。web中配置spring的上下文配置文件及配置监听。
3、整合日志
4、整合mybatis
5、整合springmvc	
6、整合ehcache
7、mybatis整合ehcache
8、整合shiro
9、整合shiro-ehcache