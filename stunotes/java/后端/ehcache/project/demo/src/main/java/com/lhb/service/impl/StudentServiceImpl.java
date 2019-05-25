package com.lhb.service.impl;

import java.util.HashMap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.lhb.dao.IStudentDao;
import com.lhb.entity.Student;
import com.lhb.service.IStudentService;

@Service("studentSer")
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private IStudentDao studentDao;

	public int deleteByPrimaryKey(String id) {
		return studentDao.deleteByPrimaryKey(id);
	}

	public int insert(Student record) {
		return studentDao.insert(record);
	}

	public int insertSelective(Student record) {
		return studentDao.insertSelective(record);
	}

	public Student selectByPrimaryKey(String id) {
		return studentDao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(Student record) {
		return studentDao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Student record) {
		return studentDao.updateByPrimaryKey(record);
	}
	/**
     * 根据条件查询列表 支持分页查找
     * @param params
     * @return
     */
	@Cacheable(value="student",key="#params")
	public List<Student> selectList(HashMap<String, Object> params) {
		return studentDao.selectList(params);
	}
	/**
     * 分页查询总条数
     * @param params
     * @return
     */
	public Integer selectListByCount(HashMap<String, Object> params) {
		return studentDao.selectListByCount(params);
	}

}
