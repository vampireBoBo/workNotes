package com.lhb.dao;

import java.util.List;

import com.lhb.entity.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    // 根据用户ID 获取用户所有角色信息
    public List<Role> selectRolesByUserID(Integer uid); 
}