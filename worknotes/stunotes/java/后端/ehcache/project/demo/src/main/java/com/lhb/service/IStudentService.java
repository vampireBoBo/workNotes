package com.lhb.service;

import java.util.HashMap;
import java.util.List;

import com.lhb.entity.Student;

public interface IStudentService {
	 /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Tue May 07 21:29:27 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Tue May 07 21:29:27 CST 2019
     */
    int insert(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Tue May 07 21:29:27 CST 2019
     */
    int insertSelective(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Tue May 07 21:29:27 CST 2019
     */
    Student selectByPrimaryKey(String id);
    
    /**
     * 根据条件查询列表 支持分页查找
     * @param params
     * @return
     */
    List<Student> selectList(HashMap<String, Object> params);
    /**
     * 分页查询总条数
     * @param params
     * @return
     */
    Integer selectListByCount(HashMap<String, Object> params);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Tue May 07 21:29:27 CST 2019
     */
    int updateByPrimaryKeySelective(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Tue May 07 21:29:27 CST 2019
     */
    int updateByPrimaryKey(Student record);
}
