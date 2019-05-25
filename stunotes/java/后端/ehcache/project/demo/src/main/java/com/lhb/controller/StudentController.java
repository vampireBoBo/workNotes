package com.lhb.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lhb.entity.Student;
import com.lhb.service.IStudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private IStudentService studentSer;
	
	@GetMapping("/manageView")
	public String toManageView(HttpServletRequest req,HttpServletResponse rep){
		return "student/stuManage";
	}
	
	/**
	 * produces:该参数处理中文显示问号的乱码问题
	 * @param req
	 * @param rep
	 * @return
	 */
	@SuppressWarnings("finally")
	@GetMapping(value="/manageData",produces="application/json;charset=UTF-8")
	public @ResponseBody String toManageData(HttpServletRequest req,HttpServletResponse rep){
		HashMap<String, Object> result = new HashMap<String, Object>();
		rep.setCharacterEncoding("UTF-8");
		try {
			List<Student> stuList = studentSer.selectList(new HashMap<String, Object>());
			result.put("status","1");
			result.put("row", stuList);
			result.put("total", stuList);
			System.out.println("查询结果："+JSON.toJSONString(stuList));
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status","-1");
		}finally {
			return JSON.toJSONString(result);
		}
	}
}
