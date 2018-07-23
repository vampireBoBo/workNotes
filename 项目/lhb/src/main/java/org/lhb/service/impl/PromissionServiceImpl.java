package org.lhb.service.impl;

import org.lhb.dao.IPermissionMapper;
import org.lhb.entity.Permission;
import org.lhb.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("permissionSer")
public class PromissionServiceImpl implements IPermissionService {
	@Autowired
	private IPermissionMapper permissionMapper;
	
	// @Override
	public int deleteByPrimaryKey(Integer permissionId) {
		return permissionMapper.deleteByPrimaryKey(permissionId);
	}

	// @Override
	public int insert(Permission record) {
		return permissionMapper.insert(record);
	}

	// @Override
	public int insertSelective(Permission record) {
		return permissionMapper.insertSelective(record);
	}

	// @Override
	public Permission selectByPrimaryKey(Integer permissionId) {
		return permissionMapper.selectByPrimaryKey(permissionId);
	}

	// @Override
	public int updateByPrimaryKeySelective(Permission record) {
		return permissionMapper.updateByPrimaryKeySelective(record);
	}

	// @Override
	public int updateByPrimaryKey(Permission record) {
		return permissionMapper.updateByPrimaryKey(record);
	}

}
