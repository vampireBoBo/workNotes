package org.lhb.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 用于shiro登录的自定义realm
 * @author Administrator
 * shiro从Realm获取安全数据，也就是说SecurityManager要验证身份，
 * 它需要从Realm获取相应的用户进行比较以确定用户的身份是否合法；
 * 我们可以把Realm看作是DataSource，安全数据源。
实现自定义Realm主要是继承AuthrizingRealm这个父类，重写doGetAuthrizationInfo和doGetAuthenticationInfo这两个方法，
其中doGetAuthenticationInfo是用来验证用户合法性的，根据输入的用户信息从数据库中查出用户，根据用户情况抛出不同的异常。
doGetAuthrizationInfo是对当前用的用户进行授权的。在这里我把角色写死了。
在实际项目开发中应该是在表中做权限和角色的定义再从数据库中查出一个集合然后迭代授权。
 */
public class CustomRealm extends AuthorizingRealm {

	/**
	 * 认证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 授权
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
