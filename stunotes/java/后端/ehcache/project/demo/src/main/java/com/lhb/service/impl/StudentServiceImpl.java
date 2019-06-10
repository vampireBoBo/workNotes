package com.lhb.service.impl;

import java.util.HashMap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.lhb.dao.IStudentDao;
import com.lhb.entity.Student;
import com.lhb.service.IStudentService;
import com.lhb.util.getUUID;

@Service("studentSer")
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private IStudentDao studentDao;

	/**
	 * 执行删除方法后  清除缓冲中关于student所有的数据 beforeInvocation表示在该方法执行之前就执行缓存的删除操作 【如果不加该属性，缓存的删除操作必须是当前方法执行成功以后才会触发】
	 */
	@CacheEvict(value="student",allEntries=true,beforeInvocation=true)
	public int deleteByPrimaryKey(String id) {
		return studentDao.deleteByPrimaryKey(id);
	}

	@CacheEvict(value="student",allEntries=true,beforeInvocation=true)
	public int insert(Student record) {
		record.setId(getUUID.getUUID());
		return studentDao.insert(record);
	}
	
	@CacheEvict(value="student",allEntries=true,beforeInvocation=true)
	public int insertSelective(Student record) {
		return studentDao.insertSelective(record);
	}

	public Student selectByPrimaryKey(String id) {
		return studentDao.selectByPrimaryKey(id);
	}
	
	@CacheEvict(value="student",allEntries=true,beforeInvocation=true)
	public int updateByPrimaryKeySelective(Student record) {
		return studentDao.updateByPrimaryKeySelective(record);
	}
	
	@CacheEvict(value="student",allEntries=true,beforeInvocation=true)
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
	@Cacheable(value="student",key="#params")
	public Integer selectListByCount(HashMap<String, Object> params) {
		return studentDao.selectListByCount(params);
	}

}
