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
 * <p>Titile: 自定义shiro-realm</p>
 * <p>Description: </p>
 * @user Administrator
 * @data 2019年1月30日
 */
public class MyRealm extends AuthorizingRealm {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IPermissionService permissionService;

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 从shiro中获取用户
		User user = (User) principals.getPrimaryPrincipal();
		
		// 授权对象的申明
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		// 角色ID集合
		ArrayList<Integer> ridList = new ArrayList<>();
		
		// 封装角色 英文名称  并统计角色ID
		List<Role> roleList = roleService.selectRolesByUserID(user.getUid());
		if(roleList!=null ){
			for(Role role:roleList){
				info.addRole(role.getRcode());
				ridList.add(role.getRid());
			}
		}
		
		// 封装权限
		if(ridList.size()>0){
			List<Permission> permissionList = permissionService.selectPermissionsByRoleIDs(ridList);
			if(permissionList!=null){
				for(Permission per:permissionList){
					info.addStringPermission(per.getPname());
				}
			}
		}
		
		return info;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 从shiro获取登录用户名
		String loginName = (String) token.getPrincipal();
		
		// 调用项目内部接口  根据用户登录名 获取用户实体信息
		HashMap<String, Object> params = new HashMap<>();
		params.put("loginName", loginName);
		User user = userService.selectByParams(params);
		
		// 若用户实体为null  表示 当前用户不存在  直接返回
		if(user==null){
			return null;
		}
		
		// 当用户存在以后  根据用户的ID 获取 用户的角色集合  并存放在用户实体中
		List<Role> roleList = roleService.selectRolesByUserID(user.getUid());
		user.setRoleList(roleList);
		
		// 用户角色不为空时  根据用户角色ID集合  获取权限集合 并存放在用户实体中
		ArrayList<Integer> rids = new ArrayList<>();
		if(roleList!=null){
			for(Role role:roleList){
				rids.add(role.getRid());
			}
		}
		if(rids.size()>0){
			List<Permission> permissionList = permissionService.selectPermissionsByRoleIDs(rids);
			user.setPermissionList(permissionList);
		}
		
		// 调用shiro接口  进行用户认证
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getLoginpassword(), this.getName());
		
		return info;
	}

}
