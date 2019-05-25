package com.lhb.controller;

import java.util.HashMap;
import java.util.Properties;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

/**
 * 邮件发送类
 * @author Administrator
 *
 */
@Controller
@RequestMapping("mail")
public class MailController {

	@Autowired
	private JavaMailSender javaMailSender;
	
	/**
	 * 给指定用户发送指定内容邮件
	 * @return  处理结果
	 */
	@SuppressWarnings("finally")
	@GetMapping(value="/send",produces="application/json;charset=UTF-8;")
	public @ResponseBody String toSendMail(){
		HashMap<String, Object> maps = new HashMap<String, Object>();
		maps.put("status", -1);
		try {
			// 创建邮件消息对象
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			
			// 读取邮箱配置文件
			Properties pro = new Properties();
			pro.load(this.getClass().getResourceAsStream("/properties/mail.properties"));
			String from = pro.getProperty("mail.smtp.username");
			
			// 消息携带对象
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
			mimeMessageHelper.setFrom(from);
			mimeMessageHelper.setTo("lihuibo_8577862@163.com");
			mimeMessageHelper.setSubject("测试邮件发送接口qqTOqq");
			mimeMessageHelper.setText("发送方式1579404542接受方应该是1670488335");
			
			// 发送邮件
			javaMailSender.send(mimeMessage);
			
			maps.put("status", 1);
			maps.put("message", "邮件发送成功");
		} catch (Exception e) {
			e.printStackTrace();
			maps.put("message","发生异常");
		}finally {
			return JSON.toJSONString(maps);
		}
	}
	
	/**
	 * 跳转至邮件发送页面
	 * @return
	 */
	@GetMapping(value="sendView")
	public String toMailView(){
		return "mail/send";
	}
	
	/**
	 * 给指定用户发送指定内容邮件
	 * @param req  
	 * @param rep
	 * @return 
	 */
	@SuppressWarnings("finally")
	@PostMapping(value="/sendByParams",produces="application/json;charset=UTF-8;")
	public @ResponseBody String toSendMailByParams(HttpServletRequest req,HttpServletResponse rep){
		// 获取参数
		String toEmail = req.getParameter("toEmail");
		String subject = req.getParameter("subject");
		String text = req.getParameter("contect");
		
		HashMap<String, Object> maps = new HashMap<String, Object>();
		maps.put("status", -1);
		try {
			// 创建邮件消息对象
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			
			// 读取邮箱配置文件  设置邮件的发送方
			Properties pro = new Properties();
			pro.load(this.getClass().getResourceAsStream("/properties/mail.properties"));
			String from = pro.getProperty("mail.smtp.username");
			
			// 消息携带对象  设置邮件的接收方及邮件主体内容
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
			mimeMessageHelper.setFrom(from);
			mimeMessageHelper.setTo(toEmail);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(text);
			
			// 发送邮件
			javaMailSender.send(mimeMessage);
			
			maps.put("status", 1);
			maps.put("message", "邮件发送成功");
		} catch (Exception e) {
			e.printStackTrace();
			maps.put("message","发生异常");
		}finally {
			return JSON.toJSONString(maps);
		}
	}
}
