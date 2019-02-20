1、mybatis-generator的使用
	1.添加generatorConfig.xml配置文件
	2.pom添加generator的插件，并制定xml文件位置及配置数据库驱动
	3.使用maven指令进行自动生成，指令：mybatis-generator:generate
	4.刷新项目，使得新建文件显示
2、创建spring的xml文件，搭建ssm项目
3、创建shiro自定义reaml及对应xml文件 
	添加shiro依赖
	重写realm
	创建shiro的xml文件
	配置web进行shiro过滤器代理，及对应的配置文件的引入
	controller使用接口实现用户登录
	
4、项目启动
	直接部署在tomcat中
	使用maven-tomcat插件进行启动,指令：tomcat7:run  、  clean tomcat7:run
	
5、日志
	slf4j + logback 
	1.添加jar包
	2.添加logback.xml文件
	3.如果logback.xml文件的位置不是src/main/resource的根目录下  则需要在web.xml中指定配置文件的位置,并配置对应的监听否则配置文件任然找不着。反之不需要，可直接使用日志打印进行测试了。
	