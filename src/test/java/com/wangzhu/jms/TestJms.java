package com.wangzhu.jms;

import org.junit.Test;

import com.wangzhu.spring.test.base.UnitTestBase;

/**
 * 下载http://apache.fayea.com/activemq/5.9.1/apache-activemq-5.9.1-bin.zip<br/>
 * 运行ActiveMQ，之后运行Test，才可以测试成功！否则报连接失败！<br/>
 * 请停止Internet Connection Sharing (ICS)服务，否则启动不了ActiveMQ。【端口冲突61616】
 * 
 * @author wangzhu
 * @date 2015-4-12下午10:24:46
 * 
 */
public class TestJms extends UnitTestBase {

	public TestJms() {
		super("classpath:spring-jms.xml");
	}

	@Test
	public void test() {
		SpringPublisher publisher = super.getBean("springPublisher");
		try {
			publisher.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
