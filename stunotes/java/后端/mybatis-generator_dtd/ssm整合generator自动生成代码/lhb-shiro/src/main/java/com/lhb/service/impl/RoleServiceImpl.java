package com.lhb.service.impl;

import org.springframework.stereotype.Service;

import com.lhb.entity.Role;
import com.lhb.service.IRoleService;

@Service("roleService")
public class RoleServiceImpl implements IRoleService {

	@Override
	public int deleteByPrimaryKey(Integer rid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Role record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Role record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Role selectByPrimaryKey(Integer rid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Role record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Role record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
