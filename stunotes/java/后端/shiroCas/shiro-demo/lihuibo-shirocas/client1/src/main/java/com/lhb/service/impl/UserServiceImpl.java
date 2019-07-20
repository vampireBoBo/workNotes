package com.lhb.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhb.dao.UserMapper;
import com.lhb.entity.User;
import com.lhb.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	public int deleteByPrimaryKey(Integer uid) {
		return userMapper.deleteByPrimaryKey(uid);
	}

	public int insert(User record) {
		return userMapper.insert(record);
	}

	public int insertSelective(User record) {
		return userMapper.insertSelective(record);
	}

	public User selectByPrimaryKey(Integer uid) {
		return userMapper.selectByPrimaryKey(uid);
	}

	public int updateByPrimaryKeySelective(User record) {
		return userMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(User record) {
		return userMapper.updateByPrimaryKey(record);
	}

	/**
	 *  根据条件检索 单个用户实体
	 */
	public User selectByParams(HashMap<String, Object> params){ 
		return userMapper.selectByParams(params);
	}

}
