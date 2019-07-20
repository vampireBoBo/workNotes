package demo;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.lhb.service.IStudentService;
/**
 * 
 * Junit单元测试  测试spring的控制反转和依赖注入   前提：以注解的方式设置好控制反转的类及属性对象的依赖注入后  
 * @author Administrator
 *
 */
@SuppressWarnings("resource")
public class JunitDemo{
	
	
	private IStudentService studentSer;
	
	@Before
	public void init(){
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath*:spring/applicationContext.xml");
		studentSer = app.getBean(IStudentService.class);
	}
	
	@Test
	public void testMess(){

		ArrayList<String> listParent = new ArrayList<String>(){{add("1");add("2");add("4");add("3");}};
		ArrayList<String> listChild = new ArrayList<String>(){{add("32");add("21");}};
		ArrayList<String> list =  new ArrayList<String>();
		try {
			for(int i=0 ;i<listParent.size();i++){
				for(int j=0;j<listChild.size();j++){
					if(listChild.get(j).indexOf(listParent.get(i))<0 && j==listChild.size()-1){
						list.add(listParent.get(i));
						continue;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
