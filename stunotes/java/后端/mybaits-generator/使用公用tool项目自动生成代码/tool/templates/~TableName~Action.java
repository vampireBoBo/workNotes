~package~.action.~beanPath~
-----------------head----------------------
package ~package~.action.~beanPath~;

import javax.annotation.Resource;

import ~package~.action.BaseAction;
import ~package~.bean.~beanPath~.~TableName~;
import ~package~.hessian.IBaseHessian;
import ~package~.hessian.~beanPath~.I~TableName~Hessian;
/**
 * 
 * CopyRright (c)2007-2013: 陕西北佳信息技术有限责任公司<br>
 * Project:BJERP<br>
 * Class Type:~TableName~  action<br>
 * Comments:Action<br>
 * JDK version:1.6<br>
 * Namespace:~package~.action.~beanPath~<br>
 * extends：BaseAction<br>
 * implements: <br>
 * --------------------------------------------------------------<br>
 * V1.0 创建  ~creater~ ~dateNow~  新项目 <br>
 * --------------------------------------------------------------<br>
 */
public class ~TableName~Action extends BaseAction{
	
	/** bean*/
	private ~TableName~ ~tableName~;
	/** Hessian接口*/
	@Resource
	private I~TableName~Hessian i~tableName~Hessian;
	
	/**
	 * 
	 * Description: 获取IBaseHessian。(子类必须继承)
	 * 
	 * @return IBaseHessian
	 */
	@Override
	public IBaseHessian getBaseHessian() {
		return i~tableName~Hessian;
	}
	
	/**
	 * 
	 * Description: 获取对象bean。(子类必须继承)
	 * 
	 * @return
	 * @return IBaseHessian
	 */
	@Override
	public Object getBean() {
		return get~TableName~();
	}
	
	/**
	 * 
	 * Description: 设置对象bean。(子类必须继承)
	 * 
	 * @return
	 * @return IBaseHessian
	 */
	public void setBean(Object obj) {
		~tableName~ = (~TableName~) obj;
	}
	
	public ~TableName~ get~TableName~() {
		return ~tableName~;
	}
	public void set~TableName~(~TableName~ ~tableName~) {
		this.~tableName~ = ~tableName~;
	}
}
