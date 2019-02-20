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
 * 重新casRelam  即重新配置数据源信息
 * @author Administrator
 *
 */
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
	 * 重新授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pricipal) {
		// 从cas中获取用户账号信息
		String loginName = (String) pricipal.getPrimaryPrincipal();
		
		// 调用本地数据  根据用户名称获取用户信息及角色和权限信息
		HashMap< String, Object> params = new HashMap<>();
		params.put("loginName", loginName);
		User user = userService.selectByParams(params);
		if(user==null){
			return null;
		}
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		List<Role> roleList = roleService.selectRolesByUserID(user.getUid());
		if(roleList!=null && roleList.size()>0){
			ArrayList<Integer> ridList = new ArrayList<>();
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
}
