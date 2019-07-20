package com.lhb.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lhb.entity.Student;
import com.lhb.service.IStudentService;

@Controller
@RequestMapping("student")
public class StudentController {
	@Autowired
	private IStudentService studentService;
	/**
	 * 查看学生集合
	 * @return
	 */
	@RequestMapping("list")
	@ResponseBody
	public String list(){
		try {
			List<Student> studentList = studentService.selectByParams(null);
			Map<String,Object> result = new HashMap<>();
			result.put("total", studentList.size());
			result.put("rows", studentList);
			return JSON.toJSONString(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
