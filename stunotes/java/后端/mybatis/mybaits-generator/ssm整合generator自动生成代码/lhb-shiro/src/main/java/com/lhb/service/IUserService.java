package com.lhb.service;

import java.util.HashMap;
import java.util.List;

import com.lhb.entity.User;

public interface IUserService {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    // 根据登录名称获取 用户
    User selectByLoginName(String loginName);
    
    // 条件查询  支持分页
    List<User> selectByParams(HashMap<String, Object> params);
    
    // 添加查询 总条数
    int selectCountByParams(HashMap<String, Object> params);
}