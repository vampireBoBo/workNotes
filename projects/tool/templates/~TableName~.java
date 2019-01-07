~package~.bean.~beanPath~
-----------------head----------------------
package ~package~.bean.~beanPath~;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 描述:<br>
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
