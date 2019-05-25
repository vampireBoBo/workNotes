操作步骤：generatorConfig - mybatis
================================================
一、generator
	1、eclipse集成mybatis插件
	2、利用mybaits插件生成generatorConfig.xml，并针对自己项目所需做必要修改 ,文件所需要存放的文件夹可以不存在，generator会自动创建。 【也可以不用集成插件 直接手动编写xml文件】
	3、maven的build添加mybatis-generator-maven-plugin  同时里面配置xml文件的位置 以及连接的数据库驱动  【需用到三个jar：mybatis.jar  mybatis-generator.jar,驱动jar。但是mybatis-generator-maven-plugin  中已经包含了前两个jar  故只需要指定数据库驱动jar即可】
	4、使用maven build： ===global：mybatis-generator:generate 【同时需注意maven的配置文件路径  指定项目的路径 】
	5、控制台显示success 后 刷新项目 即可看到
二、mybatis
	1、添加依赖
		<!-- mybatis  -->
	    <dependency>
	    	<groupId>org.mybatis</groupId>
	    	<artifactId>mybatis</artifactId>
	    	<version>${mybatis.version}</version>
	    </dependency>
	    <dependency>
	    	<groupId>org.mybatis</groupId>
	    	<artifactId>mybatis-spring</artifactId>
	    	<version>${mybatis.spring.version}</version>
	    </dependency>
	    <dependency>
	    	<groupId>mysql</groupId>
	    	<artifactId>mysql-connector-java</artifactId>
	    	<version>${mysql.version}</version>
	    </dependency>
	    <!-- 数据库连接池 -->
	    <dependency>
			<groupId>com.alibaba</groupId>
			<artifactId>druid</artifactId>
			<version>1.0.31</version>
		</dependency>
		<!-- 集成mybaits 缺少此包 提示dao不支持 -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-tx</artifactId>
			<version>${spring.version}</version>
		</dependency>
		<!-- 集成mybatis缺少此包 提示datasource不能连接数据库 -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jdbc</artifactId>
			<version>${spring.version}</version>
		</dependency>
	2、添加mybatis的xml配置 ，其配置与spring 可为一个xml。若分开，则需要在spring中引入mybatis的xml
		
	3、使用springTest接口 查看是否成功即可