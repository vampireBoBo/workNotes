package com.lhb.service;

import java.util.HashMap;

import com.lhb.entity.User;

public interface IUserService {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    // 根据条件检索 单个用户实体
    User selectByParams(HashMap<String, Object> params); 
}