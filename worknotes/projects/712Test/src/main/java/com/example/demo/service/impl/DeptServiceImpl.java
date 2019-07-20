package com.example.demo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.base.BaseServiceImpl;
import com.example.demo.base.IBaseMapper;
import com.example.demo.dao.IDeptMapper;
import com.example.demo.service.IDeptService;

/**
 * 
 * 描述:<br>
 *--------------------------------------------------------------<br>
 * V1.0 创建  lhb 2018-07-09  新项目 <br>
 *--------------------------------------------------------------<br>
 */
@Service("deptService")
public class DeptServiceImpl extends BaseServiceImpl implements IDeptService {
	@Autowired
	private IDeptMapper deptMapper;
	
	@Override
	protected IBaseMapper getIBaseMapper() {
		return deptMapper;
	}
}
