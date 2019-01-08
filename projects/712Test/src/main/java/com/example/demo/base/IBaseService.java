package com.example.demo.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * 
 * CopyRright (c)2007-2013: 西安未来国际信息股份有限公司<br>
 * Project:未来国际springMVC+Spring+Mybatis框架<br>                                  
 * Class Type:抽象类<br>
 * Comments:service 基类<br>
 * JDK version:1.8<br>
 * Namespace:com.future<br>
 * extends：<br>
 * implements：<br>
 *--------------------------------------------------------------<br>
 * V1.0 创建  wwf 2017年8月10日 <br>
 *--------------------------------------------------------------<br>
 */
public interface IBaseService {
	/**
	 * 
	 * @Description: 得到一个实体信息
	 * @param user 实体信息对象
	 * @return 实体信息
	 */
	public Object getObject(Object object);
	
	/**
	 * 
	 * @Description: 新增方法
	 * @param object
	 * @return
	 */
	public void insertObject(Object object);
	/**
	 * 
	 * @Description: 修改方法
	 * @param object
	 */
	public void updateObject(Object object);
	/**
	 * 
	 * @Description: 删除方法
	 * @param object
	 */
	public void deleteObject(Object object);
	/**
	 * 
	 * @Description: 查询多实体方法
	 * @param map
	 * @return
	 */
	public List<?> selectList(Map<String, Object> map);
	
}
