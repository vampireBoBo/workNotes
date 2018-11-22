springboot整合ssm框架
1、创建spring starter project，在创建时添加web、mysql、mybaits、jdbc等所需构建
2、pom文件添加 jsp、jstl、jackson、dbcp、devtools、tomcat等插件
3、配置application文件
4、利用mybitis的generator-config自动生成后台代码

注意：
A、默认扫描从main同级的包开始，所有的项目文件需存放在该包及以下
B、main启动时，添加对应的dao包的扫描，否则报错说mapper对应的xml文件无法扫描到
C、目前Spring Boot中默认支持的连接池有dbcp,dbcp2, tomcat, hikari三种连接池。由于Druid暂时不在Spring Bootz中的直接支持，故需要进行配置信息的定制。
D、Spring Boot选择数据库链接池实现的判断逻辑（目前好像提示HikariCP比tomcat连接池更稳定）：
    检查Tomcat的数据库链接池实现是否可用，如可用，则启用。使用spring.datasource.tomcat.*可以控制链接池的行为。
    检查HikariCP是否可用，如可用，则启用。使用spring.datasource.hikari.*可以控制链接池的行为。
    检查Commons DBCP是否可用，如可用，则启用；但Spring Boot不建议在生产环境使用该链接池的实现。
    检查Commons DBCP2是否可用，如可用，则启用。使用spring.datasource.dbcp2.*可以控制链接池的行为。

