~package~.service.~beanPath~.impl
-----------------head----------------------
package ~package~.service.~beanPath~.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.beijia.senator.mapper.IBaseMapper;
import ~package~.mapper.~beanPath~.I~TableName~Mapper;
import ~package~.service.impl.BaseServiceImpl;
import ~package~.service.~beanPath~.I~TableName~Service;

/**
 * 
 * 描述:<br>
 *--------------------------------------------------------------<br>
 * V1.0 创建  ~creater~ ~dateNow~  新项目 <br>
 *--------------------------------------------------------------<br>
 */
@Component("~tableName~Service")
public class ~TableName~ServiceImpl extends BaseServiceImpl implements I~TableName~Service {
	@Autowired
	private I~TableName~Mapper ~tableName~Mapper;
	
	@Override
	protected IBaseMapper getIBaseMapper() {
		return ~tableName~Mapper;
	}
}
