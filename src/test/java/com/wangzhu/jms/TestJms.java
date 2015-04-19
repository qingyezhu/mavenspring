package com.wangzhu.jms;

import org.junit.Test;

import com.wangzhu.spring.test.base.UnitTestBase;

/**
 * ����http://apache.fayea.com/activemq/5.9.1/apache-activemq-5.9.1-bin.zip<br/>
 * ����ActiveMQ��֮������Test���ſ��Բ��Գɹ�����������ʧ�ܣ�<br/>
 * ��ֹͣInternet Connection Sharing (ICS)���񣬷�����������ActiveMQ�����˿ڳ�ͻ61616��
 * 
 * @author wangzhu
 * @date 2015-4-12����10:24:46
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
