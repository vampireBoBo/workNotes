package com.lhb.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhb.dao.StudentMapper;
import com.lhb.entity.Student;
import com.lhb.service.IStudentService;

@Service("studentService")
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentMapper studentMapper;
	
	public int deleteByPrimaryKey(Integer uid) {
		return studentMapper.deleteByPrimaryKey(uid);
	}

	public int insert(Student record) {
		return studentMapper.insert(record);
	}

	public int insertSelective(Student record) {
		return studentMapper.insertSelective(record);
	}

	public Student selectByPrimaryKey(Integer uid) {
		return studentMapper.selectByPrimaryKey(uid);
	}

	public int updateByPrimaryKeySelective(Student record) {
		return studentMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Student record) {
		return studentMapper.updateByPrimaryKey(record);
	}
	/**
	 * 查询所有
	 */
	@Override
	public List<Student> selectByParams(HashMap<String, Object> params) {
		return studentMapper.selectByParams(params);
	}

}
