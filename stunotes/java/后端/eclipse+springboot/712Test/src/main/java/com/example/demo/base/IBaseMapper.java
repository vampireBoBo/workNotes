package com.example.demo.base;

import java.util.List;
import java.util.Map;

/**
 * 
 * CopyRright (c)2007-2013: 西安未来国际信息股份有限公司<br>
 * Project:未来国际springMVC+Spring+Mybatis框架<br>                                  
 * Class Type:接口<br>
 * Comments:mapper base 接口<br>
 * JDK version:1.8<br>
 * Namespace:com.future<br>
 * extends：<br>
 * implements：<br>
 *--------------------------------------------------------------<br>
 * V1.0 创建  wwf 2017年8月10日  新项目<br>
 *--------------------------------------------------------------<br>
 */
public interface  IBaseMapper{

	/**
	 * 
	 * @Description: 得到一个实体信息
	 * @param user 实体信息对象
	 * @return 实体信息
	 */
	public Object getObject(Object object);
	
	/**
	 * 
	 * @Description: 新增实体信息
	 * 
	 */
	public void insertObject(Object object);
	
	
	/**
	 * 
	 * @Description: 修改实体信息
	 *
	 */
	public void updateObject(Object object);
	
	
	/**
	 * 
	 * 删除用户信息
	 * 
	 * @param 用户信息对象
	 */
	public void deleteObject(Object object);
	
	/**
	 * 
	 * @Description: 查询多条实体信息
	 * @param 查询条件
	 * @return 实体信息列表
	 */
	public List<?> selectList(Map<String, Object> map);
}

