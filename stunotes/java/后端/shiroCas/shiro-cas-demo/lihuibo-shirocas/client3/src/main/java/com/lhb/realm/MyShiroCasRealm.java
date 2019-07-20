package com.lhb.realm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
 * 重新shiro-cas数据源信息
 * @author Administrator
 * @time 2019/2/25
 */
@SuppressWarnings("deprecation")
public class MyShiroCasRealm extends CasRealm {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IPermissionService permissionService;
	
	/**
	 * 重写授权接口  认证接口由casRealm进行处理
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		String loginName = (String) principal.getPrimaryPrincipal();
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
			for(Role role:roleList){
				info.addRole(role.getRcode());
				ridList.add(role.getRid());
			}
			List<Permission> permissionList = permissionService.selectPermissionsByRoleIDs(ridList);
			for(Permission permission : permissionList){
				info.addStringPermission(permission.getPname());
			}
		}
		
		return info;
	}
	
}
