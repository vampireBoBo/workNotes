package com.lhb.service.impl;

import java.util.HashMap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhb.dao.UserMapper;
import com.lhb.entity.User;
import com.lhb.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper; // user dao
	
	@Override
	public int deleteByPrimaryKey(Integer uid) {
		return userMapper.deleteByPrimaryKey(uid);
	}

	@Override
	public int insert(User record) {
		return userMapper.insert(record);
	}

	@Override
	public int insertSelective(User record) {
		return userMapper.insertSelective(record);
	}

	@Override
	public User selectByPrimaryKey(Integer uid) {
		return userMapper.selectByPrimaryKey(uid);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		return userMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(User record) {
		return userMapper.updateByPrimaryKey(record);
	}

	/**
	 * 根据登录名称获取用户信息
	 */
	@Override
	public User selectByLoginName(String loginName) {
		return userMapper.selectByLoginName(loginName);
	}
	/**
	  * 条件查询  支持分页
	 */
	@Override
    public List<User> selectByParams(HashMap<String, Object> params){
    	return userMapper.selectByParams(params);
    }
	/**
	 * 条件查询 总条数
	 */
	@Override
	public int selectCountByParams(HashMap<String, Object> params) {
		return userMapper.selectCountByParams(params);
	}

}
