package com.lhb.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhb.dao.PermissionMapper;
import com.lhb.entity.Permission;
import com.lhb.service.IPermissionService;

@Service("permissionService")
public class PermissionServiceImpl implements IPermissionService {
	
	@Autowired
	private PermissionMapper permissionMapper; // permission dao
	
	@Override
	public int deleteByPrimaryKey(Integer pid) {
		return permissionMapper.deleteByPrimaryKey(pid);
	}

	@Override
	public int insert(Permission record) {
		return permissionMapper.insert(record);
	}

	@Override
	public int insertSelective(Permission record) {
		return permissionMapper.insertSelective(record);
	}

	@Override
	public Permission selectByPrimaryKey(Integer pid) {
		return permissionMapper.selectByPrimaryKey(pid);
	}

	@Override
	public int updateByPrimaryKeySelective(Permission record) {
		return permissionMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Permission record) {
		return permissionMapper.updateByPrimaryKey(record);
	}

	/**
	 * 根据角色ID集合 获取权限集合
	 */
	@Override
	public List<Permission> selectByRoles(List<Integer> rids){
		return permissionMapper.selectByRoles(rids);
	}
	/**
	  * 条件查询  支持分页
	 */
	@Override
	public List<Permission> selectByParams(HashMap<String, Object> params) {
		return permissionMapper.selectByParams(params);
	}
	/**
	 * 条件查询 总条数
	 */
	@Override
	public int selectCountByParams(HashMap<String, Object> params) {
		return permissionMapper.selectCountByParams(params);
	}

}
