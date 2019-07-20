package com.example.demo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Dept;
import com.example.demo.service.IDeptService;
import com.example.demo.util.getUUID;

/**
 * 部门controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("dept")
public class DeptController {
	@Resource
	private IDeptService deptSer;
	
	@RequestMapping(value="deptList")
	public String toDeptManager(ModelMap map){
		Dept dept = new Dept();
		dept.setId(getUUID.getUUID());
		dept.setName("项目部");
		dept.setNo("001");
		
		return "index";	
	}
}
