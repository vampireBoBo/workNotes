package com.example.demo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.base.BaseServiceImpl;
import com.example.demo.base.IBaseMapper;
import com.example.demo.dao.IEmpMapper;
import com.example.demo.service.IEmpService;

/**
 * 
 * 描述:<br>
 *--------------------------------------------------------------<br>
 * V1.0 创建  lhb 2018-07-09  新项目 <br>
 *--------------------------------------------------------------<br>
 */
@Component("empService")
public class EmpServiceImpl extends BaseServiceImpl implements IEmpService {
	@Autowired
	private IEmpMapper empMapper;
	
	@Override
	protected IBaseMapper getIBaseMapper() {
		return empMapper;
	}
}
