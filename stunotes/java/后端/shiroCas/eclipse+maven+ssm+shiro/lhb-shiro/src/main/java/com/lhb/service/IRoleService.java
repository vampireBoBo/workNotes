package com.lhb.service;

import java.util.HashMap;

import java.util.List;

import com.lhb.entity.Role;

public interface IRoleService {
    int deleteByPrimaryKey(Integer rid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    // 根据用户ID 获取对应角色集合
    List<Role> selectByUser(Integer uid);
    
    // 条件查询  支持分页
    List<Role> selectByParams(HashMap<String, Object> params);
    
 // 添加查询 总条数
    int selectCountByParams(HashMap<String, Object> params);
}