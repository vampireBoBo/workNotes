前提：完成1中所有的操作即maven集成spring模块
================================================

注意点：junit 和 springTest 都是通过手动的方式去启动spring容器 和 手动进行注入的 所以执行的时候 项目可以不用启动。然后作为web项目 spring的容器初始化 是在web.xml通过listern去初始化spring的  
===============================================================
===使用Junit==================================================================
1、加入pom依赖
	<dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <scope>test</scope>
    </dependency>
    
    注意：scope是test时 则测试类必须存放在项目test包下
 
2、在test包下创建test类
	public class TestDemo{
		// 属性对象
		private IStudentService studentSer;
		@Before
		public void init(){
			// 通过ClassPathXmlApplicationContext对象实例化spring容器 
			ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath*:spring/applicationContext.xml");
			// 通过getBean方法从spring的IOC容器中获取所需的类 并赋值给当前属性类对象 完成属性对象的手动注入
			studentSer = app.getBean(IStudentService.class);
		}
		@Test
		public void testMess(){
			// 调用属性对象中需要测试的接口
			studentSer.getMess();
		}
	}

3、直接运行该方法 即可查看接口处理结果 【此处只测试spring的控制反转和依赖注入（手动控制初始化spring容器和依赖注入 比较费劲）  没有整合持久层故不连接数据库】

4、本质====以注解的方式配置好反转类  属性对象的依赖注入后  需要测试接口时  该类在测试类中手动初始化spring容器 然后获取当前测试类中所需要的属性对象 
	
===使用spring-test============================================================
【为什么要使用springTest：https://www.cnblogs.com/onetwo/p/6370110.html】
spring对Junit进行包装形成spring-test
1、添加pom依赖
	<dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <scope>test</scope>
    </dependency>
	<dependency>
	    <groupId>org.springframework</groupId>
	    <artifactId>spring-test</artifactId>
	    <version>${spring.version}</version>
	    <scope>test</scope>
	</dependency>
2、创建测试类====【【【【如果被测试接口中包含外部的dubbo接口 则需要将多对应的注入文件也引入进来  locations={"classpath:spring/root-context.xml","classpath:spring/spring-dubbo.xml","classpath:spring/spring-activityMQ.xml"})】】】

	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
	public class SpringTestDemo{
		@Autowired
		private IStudentService studentSer;
		@Test
		public void testMess(){
			studentSer.getMess();
		}
	}
	
3、本质：在注解方式配置好需要测试的接口后，在创建测试类时，添加类注解@RunWith @ContextConfiguration ，然后测试类中的所需测试的接口类的获取 可以直接使用spring的依赖注入注解
	
	
	
