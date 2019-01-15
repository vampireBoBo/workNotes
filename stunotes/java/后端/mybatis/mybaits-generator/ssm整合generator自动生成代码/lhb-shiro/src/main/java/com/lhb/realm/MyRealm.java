package com.lhb.realm;

import java.util.ArrayList;
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
 * 自定义realm
 * @author Administrator
 *
 */
public class MyRealm extends AuthorizingRealm {
	
	@Autowired
	private IUserService userService; // 用户 service
	
	@Autowired
	private IRoleService roleService; // 角色 service
	
	@Autowired
	private IPermissionService permissionService; // 权限 service

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 获取当前用户  
		User user = (User) principals.getPrimaryPrincipal();
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		// 封装用户角色 和  权限
		List<Role> roleList = roleService.selectByUser(user.getUid());
		for(Role role : roleList){
			info.addRole(role.getRcode());
		}
		
		// 获取用户的角色id
		List<Integer> rids = new ArrayList<>();
		for(Role role:roleList){
			rids.add(role.getRid());
		}
		
		List<Permission> permissionList = permissionService.selectByRoles(rids);
		for(Permission permission : permissionList){
			info.addStringPermission(permission.getPname());
		}
		
		return info;
	}
	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken tocken) throws AuthenticationException {
		// 通过shiro框架 通过登录tocken手令  得到当前登录账号
		String  loginName = (String) tocken.getPrincipal();
		
		// 通过登录账号获取用户信息
		User user = userService.selectByLoginName(loginName);
		
		if(user == null){
			return null;
		}
		
		// 获取用户的角色 
		List<Role> roleList = roleService.selectByUser(user.getUid()); 
		
		// 获取用户的角色id
		List<Integer> rids = new ArrayList<>();
		for(Role role:roleList){
			rids.add(role.getRid());
		}
		
		// 获取用户的权限
		List<Permission> permissionList = null;
		if (rids.size()>0){
			permissionList = permissionService.selectByRoles(rids);
		}
	
		// 封装数据
		user.setRoleList(roleList);
		user.setPermissionList(permissionList);
		
		// 继续执行 shiro验证
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getLoginpassword(), this.getName());
		
		return info;
	}

}
