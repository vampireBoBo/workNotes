package com.lhb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lhb.entity.Student;
import com.lhb.service.IStudentService;
import com.lhb.util.Result;

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
	public Result list(){
		try {
			List<Student> studentList = studentService.selectByParams(null);
			return Result.SUCCESS(studentList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.FAILURE();
	}
	
}
