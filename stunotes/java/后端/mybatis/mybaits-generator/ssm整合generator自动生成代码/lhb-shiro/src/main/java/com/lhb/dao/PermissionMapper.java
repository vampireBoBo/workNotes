package com.lhb.dao;

import java.util.HashMap;
import java.util.List;

import com.lhb.entity.Permission;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    
    // 根据角色集合 获取权限集合
    List<Permission> selectByRoles(List<Integer> rids);
    
    // 条件查询  支持分页
    List<Permission> selectByParams(HashMap<String, Object> params);
    
    // 添加查询 总条数
    int selectCountByParams(HashMap<String, Object> params);
}