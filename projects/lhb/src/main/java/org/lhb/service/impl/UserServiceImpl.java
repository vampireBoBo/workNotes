package org.lhb.service.impl;

import org.lhb.dao.IUserMapper;
import org.lhb.entity.User;
import org.lhb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userSer")
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserMapper userMapper;
	
	public int deleteByPrimaryKey(Integer userId) {
		return userMapper.deleteByPrimaryKey(userId);
	}

	public int insert(User record) {
		return userMapper.insert(record);
	}

	public int insertSelective(User record) {
		return userMapper.insertSelective(record);
	}

	public User selectByPrimaryKey(Integer userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	public int updateByPrimaryKeySelective(User record) {
		return userMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(User record) {
		return userMapper.updateByPrimaryKey(record);
	}

}
