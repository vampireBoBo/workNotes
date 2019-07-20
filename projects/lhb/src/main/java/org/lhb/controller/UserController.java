package org.lhb.controller;

import java.util.Map;

import org.lhb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户类
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	private IUserService userSer;
	
	@RequestMapping(value="/login/{username}",method=RequestMethod.GET)
	@ResponseBody
	public String login(@PathVariable String username,Map<String,Object> map){
		map.put("name", username);
		return username;
	}
	
}
