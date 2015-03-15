package com.wangzhu.spring.lifecycle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.wangzhu.spring.test.base.UnitTestBase;

/**
 * Bean的生命周期【实现接口、定义Bean时指定（当存在时，必须实现方法），默认全局】
 * 
 * @author wangzhu
 * @date 2015-3-7下午2:23:24
 * 
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestBeanLifeCycle extends UnitTestBase {

	public TestBeanLifeCycle() {
		super("classpath*:spring-lifecycle.xml");
	}

	@Test
	public void test() {
		super.getBean("beanLifeCycle");
	}

}
