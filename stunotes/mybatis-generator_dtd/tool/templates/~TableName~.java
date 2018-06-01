~package~.bean.~beanPath~
-----------------head----------------------
package ~package~.bean.~beanPath~;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * CopyRright (c)2007-2013: 陕西北佳信息技术有限责任公司<br>
 * Project:BJERP<br>
 * Class Type:~TableName~信息Bean<br>
 * Comments:<br>
 * JDK version:1.6<br>
 * Namespace:~package~.bean.~beanPath~<br>
 * extends: <br>
 *--------------------------------------------------------------<br>
 * V1.0 创建  ~creater~ ~dateNow~  新项目 <br>
 *--------------------------------------------------------------<br>
 */
public class ~TableName~ implements Serializable{

	~!iterator!~
	private ~iterator.type~ ~iterator.columnName~;
	~!!iterator!~
	
	~!iterator!~
	public ~iterator.type~ get~iterator.ColumnName~() {
		return ~iterator.columnName~;
	}
	public void set~iterator.ColumnName~(~iterator.type~ ~iterator.columnName~) {
		this.~iterator.columnName~ = ~iterator.columnName~;
	}
	~!!iterator!~

}
