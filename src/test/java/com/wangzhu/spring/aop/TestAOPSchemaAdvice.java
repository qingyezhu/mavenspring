package com.wangzhu.spring.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.wangzhu.spring.aop.schema.advice.biz.AspectBiz;
import com.wangzhu.spring.test.base.UnitTestBase;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestAOPSchemaAdvice extends UnitTestBase {

	public TestAOPSchemaAdvice() {
		super("classpath:spring-aop-schema-advice.xml");
	}

	@Test
	public void testBiz() {
		AspectBiz biz = super.getBean("aspectBiz");
		biz.biz();
	}

	@Test
	public void testBizException() {
		AspectBiz biz = super.getBean("aspectBiz");
		biz.bizException();
	}

	@Test
	public void testInit() {
		AspectBiz biz = super.getBean("aspectBiz");
		biz.init("aspect", 100);
	}

}
