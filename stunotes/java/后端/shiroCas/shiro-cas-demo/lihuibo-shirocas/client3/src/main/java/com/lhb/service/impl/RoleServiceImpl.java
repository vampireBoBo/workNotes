package com.lhb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhb.dao.RoleMapper;
import com.lhb.entity.Role;
import com.lhb.service.IRoleService;

@Service("roleService")
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	public int deleteByPrimaryKey(Integer rid) {
		return roleMapper.deleteByPrimaryKey(rid);
	}

	public int insert(Role record) {
		return roleMapper.insert(record);
	}

	public int insertSelective(Role record) {
		return roleMapper.insertSelective(record);
	}

	public Role selectByPrimaryKey(Integer rid) {
		return roleMapper.selectByPrimaryKey(rid);
	}

	public int updateByPrimaryKeySelective(Role record) {
		return roleMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Role record) {
		return roleMapper.updateByPrimaryKey(record);
	}

	/* (non-Javadoc)
	 * @see com.lhb.service.IRoleService#selectRolesByUserID(java.lang.String)
	 */
	public List<Role> selectRolesByUserID(Integer uid) {
		return roleMapper.selectRolesByUserID(uid);
	}

}
