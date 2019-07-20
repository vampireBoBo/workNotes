package com.lhb.realm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.lhb.entity.Permission;
import com.lhb.entity.Role;
import com.lhb.entity.User;
import com.lhb.service.IPermissionService;
import com.lhb.service.IRoleService;
import com.lhb.service.IUserService;
/**
 * shiro-cas realm自定义
 * @author Administrator
 *
 */
@SuppressWarnings("deprecation")
public class MyCasRealm extends CasRealm {
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IPermissionService permissionService;
	
	/**
	 * 认证---认证为cas认证即统一认证  故这里不需要重写
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		return super.doGetAuthenticationInfo(token);
	}
	/**
	 * 授权--- 针对这个子系统下 当前用户的全新信息获取
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pricipal) {
		// 得到当前登录的用户  并在当前项目指定的数据库中进行用户角色和权限的获取  最后完成数据的封装
		String loginName = (String) pricipal.getPrimaryPrincipal();
		HashMap<String, Object> params = new HashMap<>();
		params.put("loginName", loginName);
		User user = userService.selectByParams(params);
		
		if(user==null){
			return null;
		}
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		List<Role>  roleList = roleService.selectRolesByUserID(user.getUid());
		if(roleList!=null && roleList.size()>0){
			ArrayList<Integer> ridList = new ArrayList<>();
			for(Role r:roleList){
				info.addRole(r.getRcode());
				ridList.add(r.getRid());
			}
			List<Permission> permissionList = permissionService.selectPermissionsByRoleIDs(ridList);
			for(Permission p:permissionList){
				info.addStringPermission(p.getPname());
			}
		}
		
		return info;
	}
}
