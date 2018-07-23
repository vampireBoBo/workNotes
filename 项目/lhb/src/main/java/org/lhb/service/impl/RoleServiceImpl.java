package org.lhb.service.impl;

import org.lhb.dao.IRoleMapper;
import org.lhb.entity.Role;
import org.lhb.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("roleSer")
public class RoleServiceImpl implements IRoleService {
	@Autowired
	private IRoleMapper roleMapper;
	
	// @Override
	public int deleteByPrimaryKey(Integer roleId) {
		return roleMapper.deleteByPrimaryKey(roleId);
	}

	// @Override
	public int insert(Role record) {
		return roleMapper.insert(record);
	}

	// @Override
	public int insertSelective(Role record) {
		return roleMapper.insertSelective(record);
	}

	// @Override
	public Role selectByPrimaryKey(Integer roleId) {
		return roleMapper.selectByPrimaryKey(roleId);
	}

	// @Override
	public int updateByPrimaryKeySelective(Role record) {
		return roleMapper.updateByPrimaryKeySelective(record);
	}

	// @Override
	public int updateByPrimaryKey(Role record) {
		return roleMapper.updateByPrimaryKey(record);
	}

}
