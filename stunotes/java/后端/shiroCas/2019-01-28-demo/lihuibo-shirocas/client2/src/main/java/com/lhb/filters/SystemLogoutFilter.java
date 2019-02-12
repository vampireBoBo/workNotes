package com.lhb.filters;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.springframework.stereotype.Service;

/**
 * <p>Titile: shiro-logout-filter</p>
 * <p>Description: 重写注销filter  需要使用service进行实体的托管 因为在spring容器中没有使用bean声明</p>
 * @user Administrator
 * @data 2019年2月11日
 */
@Service("systemLogoutFilter")
public class SystemLogoutFilter extends LogoutFilter {
	/**
	 * 重写preHandler接口  
	 */
	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		// 此处可以进行指定数据的清除
		
		Subject subject = getSubject(request, response);
		String redirectUrl = getRedirectUrl();
		
		// 执行shiro内置logout
		try {
            subject.logout();
        } catch (Exception ise) {
           ise.printStackTrace();
        }
		
		issueRedirect(request, response, redirectUrl);

		//返回false表示不执行后续的过滤器，直接返回跳转到登录页面
        return false;
	}
}
