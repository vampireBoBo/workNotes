package com.lhb.service;

import java.util.ArrayList;
import java.util.List;

import com.lhb.entity.Permission;

public interface IPermissionService {
    int deleteByPrimaryKey(Integer pid);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    
    // 根据角色id的list获取 对应的权限list
    public List<Permission> selectPermissionsByRoleIDs(ArrayList<Integer> list);
}