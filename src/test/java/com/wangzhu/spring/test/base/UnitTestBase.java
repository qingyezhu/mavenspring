package com.wangzhu.spring.test.base;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

public class UnitTestBase {
	private String springXmlpath;
	private ClassPathXmlApplicationContext context;

	public UnitTestBase() {
	}

	public UnitTestBase(String springXmlpath) {
		this.springXmlpath = springXmlpath;
	}

	@Before
	public void before() {
		if (StringUtils.isEmpty(springXmlpath)) {
			springXmlpath = "classpath*:spring-*.xml";
		}
		context = new ClassPathXmlApplicationContext(
				springXmlpath.split("[,\\s]+"));
		context.start();
	}

	@After
	public void after() {
		context.destroy();
	}

	protected <T extends Object> T getBean(Class<T> clazz) {
		return context.getBean(clazz);
	}

	@SuppressWarnings("unchecked")
	protected <T extends Object> T getBean(String beanId) {
		return (T) context.getBean(beanId);
	}
}
