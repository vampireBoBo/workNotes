package com.lhb.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("user")
public class UserController {
	
	private Logger log = Logger.getLogger(getClass());
	
	@ResponseBody
	@RequestMapping("/test")
	public String toIndex(){
		log.debug("测试方法开始执行");
		return JSON.toJSONString("hello world I want hug you");
	}
}
