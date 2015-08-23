package com.wangzhu.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wangzhu.spring.test.base.UnitTestBase;

@RunWith(BlockJUnit4ClassRunner.class)
public class DubboConsumerTest extends UnitTestBase {

	private static final Logger logger = LoggerFactory
			.getLogger(DubboConsumerTest.class);

	public DubboConsumerTest() {
		super("classpath:applicationContext-dubbo-consumer.xml");
	}

	@Test
	public void dubboConsumer() {
		DubboProviderDemoService dubboDemoService = super
				.getBean("dubboDemoService");

		DubboConsumerTest.logger.info("test dubbo ==== {}",
				dubboDemoService.hello("welcome to dubbo"));
	}
}
