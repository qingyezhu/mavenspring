package com.wangzhu.spring.aware;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.wangzhu.spring.test.base.UnitTestBase;

/**
 * ApplicationAware与BeanNameAware接口
 * 
 * @author wangzhu
 * @date 2015-3-7下午2:23:54
 * 
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestAware extends UnitTestBase {

	public TestAware() {
		super("classpath*:spring-aware.xml");
	}

	@Test
	public void testMyApplicationAware() {
		System.out.println("testMyApplicationAware: "
				+ super.getBean("myApplicationAware").hashCode());
	}

	@Test
	public void testMyBeanNameAware() {
		System.out.println("testMyBeanNameAware: "
				+ super.getBean("myBeanNameAware"));
	}

	@Test
	public void testBeanNameApplicationAware() {
		System.out.println("testBeanNameApplicationAware: "
				+ super.getBean("beanNameApplicationAware").hashCode());
	}

}
