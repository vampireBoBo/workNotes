package demo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.lhb.entity.Student;
import com.lhb.service.IStudentService;
import com.lhb.util.getUUID;

import lombok.extern.slf4j.Slf4j;

/**
 * 继承父类  父类已经完成了application文件的加载  即spring容器的初始化
 * @author Administrator
 *
 */
@Slf4j
public class SpringTestDemo extends SpringTestBasicTest{
	
	@Autowired
	private IStudentService studentSer;
	
	public void insertTest(){
		Student stu = new Student();
		stu.setId(getUUID.getUUID());
		stu.setSno("003");
		stu.setSname("安以轩");
		stu.setSex(1);
		stu.setAge(18);
		// 新增结果为1  表示成功
		int result = studentSer.insert(stu);
		log.error("新增处理结果是："+result);
	}
	
	@Test
	public void selectById(){
		Student stu = studentSer.selectByPrimaryKey("0124c86d23eb444cb6653ddfbfe58b61");
		System.out.println("查询结果："+JSON.toJSONString(stu));
	}
	
}
