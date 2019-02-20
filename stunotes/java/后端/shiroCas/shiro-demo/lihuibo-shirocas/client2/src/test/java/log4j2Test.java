

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * 学习链接：https://blog.csdn.net/vbirdbest/article/details/71751835
 * @author Administrator
 * 直接使用log4j2的实现类 进行日志的打印，即导入的包为：org.apache.logging.log4j.LogManager
 */
public class log4j2Test {
	public static void main(String[] args) {
		Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
		log.error("lhbtest");
		log.debug("lhbdebug");
	}
}
