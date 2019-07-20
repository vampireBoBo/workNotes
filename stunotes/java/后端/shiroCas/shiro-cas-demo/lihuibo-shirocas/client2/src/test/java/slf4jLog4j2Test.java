

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 学习链接：https://blog.csdn.net/vbirdbest/article/details/71751835
 * @author Administrator
 * 使用slf4j + log4j2 进行日志的打印  即导入的包为：org.slf4j.Logger
 */
public class slf4jLog4j2Test {
	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(slf4jLog4j2Test.class);
		log.debug("测试slf4j+log4j2日志信息");
		log.error("测试slf4j+log4j2日志信息");
	}
}
