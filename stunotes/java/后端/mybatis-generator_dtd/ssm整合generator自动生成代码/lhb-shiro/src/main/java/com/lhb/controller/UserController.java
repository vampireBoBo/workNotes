package com.lhb.controller;

import java.util.HashMap;
import java.util.List;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lhb.entity.User;
import com.lhb.service.IUserService;
import com.lhb.util.Result;


@Controller
@RequestMapping("user")
public class UserController {
	
	// private Logger log = Logger.getLogger(getClass());
	@Autowired
	private IUserService userService; // 用户 service
	
	/**
	 * 用户 UI
	 * @return  对应页面
	 */
	@RequestMapping("/userUI")
	@RequiresAuthentication
	public String toIndex(){
		return "user/userList";
	}
	/**
	 * 用户 list
	 * @return  list json格式
	 */
	@SuppressWarnings("unchecked")
	@RequiresPermissions(value="user:list,user:list",logical=Logical.OR)
	@RequestMapping("/list")
	@ResponseBody
	public Result list(String param){
		try {
			HashMap<String, Object> params = new HashMap<>();
			params = (HashMap<String, Object>) JSON.parse(param);
			List<User> userList = userService.selectByParams(params);
			int count= userService.selectCountByParams(params);
			params.clear();
			params.put("row", userList);
			params.put("total", count);
			return Result.succeed(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.fail();
	}
}
