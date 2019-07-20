package com.lhb.realm;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.lhb.entity.Permission;
import com.lhb.entity.Role;
import com.lhb.entity.User;
import com.lhb.service.IPermissionService;
import com.lhb.service.IRoleService;
import com.lhb.service.IUserService;

/**
 * <p>Titile: </p>
 * <p>Description: 自定义realm</p>
 * @user Administrator
 * @data 2019年2月11日
 */
public class MyRealm extends AuthorizingRealm {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IPermissionService permissionService;

	/* 授权
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 获取用户登录名 并通过对应数据库 获取用户角色信息 封装在shiro框架对应实体中
		User user = (User) principals.getPrimaryPrincipal();
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		List<Role> roleList = roleService.selectRolesByUserID(user.getUid());
		ArrayList<Integer> ridList = new ArrayList<Integer>();
		if(roleList!=null && roleList.size()>0){
			for(Role r:roleList){
				ridList.add(r.getRid());
				info.addRole(r.getRcode());
			}
			List<Permission> permissionList = permissionService.selectPermissionsByRoleIDs(ridList);
			for(Permission p:permissionList){
				info.addStringPermission(p.getPname());
			}
		}
		
		return info;
	}

	/* 认证
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 根据token个登录名  调用本地数据库进行用户认证
		String loginName = (String) token.getPrincipal();
		HashMap<String ,Object> params = new HashMap<String, Object>();
		params.put("loginName", loginName);
		User user = userService.selectByParams(params);
		
		if(user==null){
			return null;
		}
		
		// 封装需要的用户和角色信息 也可以不封装  通过对应的注解 去调用授权功能获取对应的角色和权限信息
		List<Role> roleList =  roleService.selectRolesByUserID(user.getUid());
		ArrayList<Integer> ridList = new ArrayList<Integer>(); 
		if(roleList!=null && roleList.size()>0){
			user.setRoleList(roleList);
			for(Role r :roleList){
				ridList.add(r.getRid());
			}
			List<Permission> permissionList = permissionService.selectPermissionsByRoleIDs(ridList);
			if(permissionList!=null && permissionList.size()>0){
				user.setPermissionList(permissionList);
			}
		}
		
		// 若用户存在 则进行封装返回
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getLoginpassword(), this.getName());
		
		return info;
	}

}
