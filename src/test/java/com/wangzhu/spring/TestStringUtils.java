package com.wangzhu.spring;

import org.junit.Test;

import com.wangzhu.aop.StringUtils;
import com.wangzhu.spring.test.base.UnitTestBase;

public class TestStringUtils extends UnitTestBase {

	public TestStringUtils() {
		super("classpath:spring-aop.xml");
	}

	@Test
	public void test() {
		StringUtils stringUtils = this.getBean("stringUtils");
		stringUtils.testAdd();
		stringUtils.testConcat();
		stringUtils.testStringBuilder();
	}
}
