package com.lhb.controller;

import java.util.HashMap;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

/**
 * 短信controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("sms")
public class SmsController {

	/**
	 * 给指定用户发送短信
	 * @return
	 */
	@RequestMapping(value="send",produces="application/json;charset=UTF-8")
	@SuppressWarnings("finally")
	public @ResponseBody String toSend(){
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("status", -1);
		try {
			HttpClient client = new HttpClient();
			PostMethod post = new PostMethod("http://gbk.api.smschinese.cn"); 
			post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
			// uid:本站用户名  key:接口安全秘钥   smsMob:用于接收短信的手机号码    smsText：短信内容
			NameValuePair[] data ={ new NameValuePair("Uid", "lihuibo"),new NameValuePair("Key", "d41d8cd98f00b204e980"),new NameValuePair("smsMob","18821715486"),new NameValuePair("smsText","您的验证码：8888")};
			post.setRequestBody(data);

			client.executeMethod(post);
			Header[] headers = post.getResponseHeaders();
			int statusCode = post.getStatusCode();
			System.out.println("statusCode:"+statusCode);
			for(Header h : headers)
			{
			System.out.println(h.toString());
			}
			String result = new String(post.getResponseBodyAsString().getBytes("gbk")); 
			System.out.println(result); //打印返回消息状态
			post.releaseConnection();
			params.put("status", 1);
			params.put("msg","发送成功");
		} catch (Exception e) {
			e.printStackTrace();
			params.put("msg", e.getMessage());
		}finally {
			return JSON.toJSONString(params);
		}
	}
}
