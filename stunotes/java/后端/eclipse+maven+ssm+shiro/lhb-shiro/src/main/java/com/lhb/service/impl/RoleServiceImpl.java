package com.lhb.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhb.dao.RoleMapper;
import com.lhb.entity.Role;
import com.lhb.service.IRoleService;

@Service("roleService")
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private RoleMapper roleMapper;  // role dao
	
	@Override
	public int deleteByPrimaryKey(Integer rid) {
		return roleMapper.deleteByPrimaryKey(rid);
	}

	@Override
	public int insert(Role record) {
		return roleMapper.insert(record);
	}

	@Override
	public int insertSelective(Role record) {
		return roleMapper.insertSelective(record);
	}

	@Override
	public Role selectByPrimaryKey(Integer rid) {
		return roleMapper.selectByPrimaryKey(rid);
	}

	@Override
	public int updateByPrimaryKeySelective(Role record) {
		return roleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Role record) {
		return roleMapper.updateByPrimaryKey(record);
	}

	/**
	 * 根据用户ID 获取角色集合
	 */
	@Override
	public List<Role> selectByUser(Integer uid) {
		return roleMapper.selectByUser(uid);
	}

	/**
	  * 条件查询  支持分页
	 */
	@Override
	public List<Role> selectByParams(HashMap<String, Object> params) {
		return roleMapper.selectByParams(params);
	}
	/**
	 * 条件查询 总条数
	 */
	@Override
	public int selectCountByParams(HashMap<String, Object> params) {
		return roleMapper.selectCountByParams(params);
	}

}
