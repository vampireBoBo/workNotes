package mainTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class logbackSlf4jTests {
	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(logbackSlf4jTests.class);
		log.error("严重错误测试");
	}
}
