1、在resource添加generator的配置文件，配置文件context的元素数量及顺序固定 ，否则会报错提示context的元素要求。

	注意: 项目的路径为：src/main/java   例如：targetProject="src/main/resources"
2、pom文件中配置项目的bulid，配置时需要注意：

	默认情况下  项目会从resource项目下查找generatorConfig.xml文件，故如果项目文件及路径不是默认值时，则进行configuration的配置。同时，可在plugin中的dependencies中配置mysql的连接驱动。
	使用generator会需要三个jar包：mybatis的jar包、mybatis-generator的jar包，mysql-connection驱动jar。ssm框架项目中，通过配置mybatis-generator-maven-plugin后直接配置了mybaits和generator的jar包，故只需要再指定mysql-connection的jar即可。需要注意若不成功时，可尝试是使用mysql的驱动版本号为：5.1.30
	
	例如：	<plugin>
		        <groupId>org.mybatis.generator</groupId>
		        <artifactId>mybatis-generator-maven-plugin</artifactId>
		        <version>1.3.5</version>
		        <configuration>
			          <verbose>true</verbose>
			          <overwrite>true</overwrite>
			          <configurationFile>src/main/resources/util/generatorConfig.xml</configurationFile>	
		        </configuration>
		        <dependencies>
		          	  <!-- 数据库驱动 -->
			          <dependency>
						    <groupId>mysql</groupId>
						    <artifactId>mysql-connector-java</artifactId>
						    <version>5.1.30</version>
					  </dependency>
		        </dependencies>
		    </plugin>
		    
3、使用maven指令自动生成代码

	右键项目---》run as ---》run configurations（最后一项）--->maven bulid(双击新建指令)---》右侧进行指令设置
		Name:设置指令名称
		Base directory:Browse Workspace    例如：${workspace_loc:/lhb-shiro}
		Goals:mybatis-generator:generate
		User settings:本地maven库的setting文件
		Maven Runtime：拉到最下面  这只本地maven软件安装路径
		apply--run
		
		注意：若generatorConfig中设置的输出文件夹不存在时 会自动创建  
		