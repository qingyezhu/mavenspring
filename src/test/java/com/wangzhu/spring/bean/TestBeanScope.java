package com.wangzhu.spring.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.wangzhu.spring.test.base.UnitTestBase;

/**
 * Bean×÷ÓÃÓò¡¾singleton,prototype¡¿
 * 
 * @author wangzhu
 * @date 2015-3-7ÏÂÎç2:23:49
 * 
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestBeanScope extends UnitTestBase {
	public TestBeanScope() {
		super("classpath*:spring-beanscope.xml");
	}

	@Test
	public void testSay() {
		System.out.println("singleton");
		BeanScope beanSingleton1 = this.getBean("beanSingleton");
		beanSingleton1.say();
		BeanScope beanSingleton2 = this.getBean("beanSingleton");
		beanSingleton2.say();

		System.out.println("prototype");
		BeanScope beanPrototype1 = this.getBean("beanPrototype");
		beanPrototype1.say();
		BeanScope beanPrototype2 = this.getBean("beanPrototype");
		beanPrototype2.say();

	}

}
