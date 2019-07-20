package com.lhb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhb.dao.PermissionMapper;
import com.lhb.entity.Permission;
import com.lhb.service.IPermissionService;
@Service("permissionService")
public class PermissionServiceImpl implements IPermissionService {

	@Autowired
	private PermissionMapper permissionMapper;
	
	public int deleteByPrimaryKey(Integer pid) {
		return permissionMapper.deleteByPrimaryKey(pid);
	}

	public int insert(Permission record) {
		return permissionMapper.insert(record);
	}

	public int insertSelective(Permission record) {
		return permissionMapper.insertSelective(record);
	}

	public Permission selectByPrimaryKey(Integer pid) {
		return permissionMapper.selectByPrimaryKey(pid);
	}

	public int updateByPrimaryKeySelective(Permission record) {
		return permissionMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Permission record) {
		return permissionMapper.updateByPrimaryKey(record);
	}

	/* (non-Javadoc)
	 * @see com.lhb.service.IPermissionService#selectPermissionsByRoleIDs(java.util.ArrayList)
	 */
	public List<Permission> selectPermissionsByRoleIDs(ArrayList<Integer> list) {
		return permissionMapper.selectPermissionsByRoleIDs(list);
	}

}
