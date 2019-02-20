1、日志体系
	slf4j log4j12
	
2、集成cas
	A、pom添加jar包
		<dependency>
            <groupId>org.apache.shiro</groupId>
            <artifactId>shiro-spring</artifactId>
            <version>${shiro.version}</version>
        </dependency>
        <!-- shiro-cas集成依赖包 -->
        <dependency>
            <groupId>org.apache.shiro</groupId>
            <artifactId>shiro-cas</artifactId>
            <version>${shiro.version}</version>
        </dependency>
	B、重写CasRealm
	C、配置shiro-cas的配置文件
	D、调整shiro.xml
	F、将shiro.xml引入application或者直接在web中引入xml文件