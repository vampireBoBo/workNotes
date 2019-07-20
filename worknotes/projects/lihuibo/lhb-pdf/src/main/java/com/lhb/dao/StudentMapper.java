package com.lhb.dao;

import java.util.HashMap;
import java.util.List;

import com.lhb.entity.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    
    // 查询所有
    List<Student> selectByParams(HashMap<String, Object> params);
}