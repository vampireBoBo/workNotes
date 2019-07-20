package com.example.demo.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * 
 * CopyRright (c)2007-2013: 西安未来国际信息股份有限公司<br>
 * Project:未来国际springMVC+Spring+Mybatis框架<br>                                  
 * Class Type:抽象类<br>
 * Comments:service实现类基类<br>
 * JDK version:1.8<br>
 * Namespace:com.future<br>
 * extends：<br>
 * implements：<br>
 *--------------------------------------------------------------<br>
 * V1.0 创建  wwf 2017年8月10日  新项目<br>
 *--------------------------------------------------------------<br>
 */
public class BaseServiceImpl implements IBaseService{
	/**
	 * 
	 * Description: 子类继承该方法。获取Mapper。
	 * 
	 * @return
	 */
	protected IBaseMapper getIBaseMapper() {
		return null;
	}

	@Override
	public Object getObject(Object object) {
		return getIBaseMapper().getObject(object);
	}
	

	
	@Override
	public void insertObject(Object object) {
		getIBaseMapper().insertObject(object);
	 
	}
	
	
	
	

	@Override
	public void updateObject(Object object) {
		getIBaseMapper().updateObject(object);
	}
	
	

	@Override
	public void deleteObject(Object object) {
		getIBaseMapper().deleteObject(object);
	}

    
	@Override
	public List<?> selectList(Map<String, Object> map) {
		return getIBaseMapper().selectList(map);
	}

	/**
	 * @Description: 递归查询树列表
	 * @param map
	 * @return
	 */
	public String jsonTree(HashMap<String, Object> map){
		StringBuilder sb = new StringBuilder();
		sb.append(jsonTreeRecursion(map));
		return sb.toString();
	}
	
	/**
	 * @Description: 递归函数
	 * @param map
	 * @return
	 */
	public String jsonTreeRecursion(HashMap<String, Object> map){
		StringBuilder sb = new StringBuilder();
		//根据code查询节点
		List<?> oneList = getIBaseMapper().selectList(map);
		sb.append("[");
		for(int i=0;i<oneList.size();i++){
			@SuppressWarnings("unchecked")
			HashMap<String,Object> oneMap = ((HashMap<String, Object>) oneList.get(i));
			sb.append("{\"id\":\"" + oneMap.get("id")+"\",\"name\":\"" + oneMap.get("name")+"\",\"code\":\"" + oneMap.get("code")+"\"");
			//判断该节点下是否存在子级
			map.clear();
			map.put("code", "'"+oneMap.get("code")+"___'");
			@SuppressWarnings("unchecked")
			List<HashMap<String,Object>> childList = ((List<HashMap<String, Object>>) getIBaseMapper().selectList(map));
			if(childList.size()>0){
				map.put("code", "'"+oneMap.get("code")+"___'");
				sb.append(",\"children\":");
				sb.append(jsonTreeRecursion(map));
			}
			sb.append("},");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		return sb.toString();
	}
}
