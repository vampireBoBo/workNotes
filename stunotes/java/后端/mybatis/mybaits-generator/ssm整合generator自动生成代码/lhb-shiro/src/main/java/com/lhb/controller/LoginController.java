package com.lhb.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lhb.entity.User;
import com.lhb.util.Result;

/**
 * 系统 用户登录 退出请求处理类
 * @author Administrator
 *
 */
@Controller
public class LoginController {
	/**
	 * 用户登录
	 * @param userName
	 * @param password
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public Result login(String userName,String password){
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		Subject subject = SecurityUtils.getSubject();
		
		try {
			subject.login(token);
		} catch (UnknownAccountException e) {
			return Result.fail(403,"用户名不存在");
		}catch (IncorrectCredentialsException e){
			return Result.fail(403,"密码不正确");
		}
		
		return Result.succeed("/home");
	}
	/**
	 * 登录成功后 跳转到 home页面
	 * @param req
	 * @return
	 */
	@RequestMapping("/home")
	public String toHome(HttpServletRequest req){
		// 存放用户信息  用于页面处理权限功能
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		req.setAttribute("loginUser", user);
		return "home";
	}
}
