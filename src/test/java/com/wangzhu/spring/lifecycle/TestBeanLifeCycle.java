package com.wangzhu.spring.lifecycle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.wangzhu.spring.test.base.UnitTestBase;

/**
 * Bean���������ڡ�ʵ�ֽӿڡ�����Beanʱָ����������ʱ������ʵ�ַ�������Ĭ��ȫ�֡�
 * 
 * @author wangzhu
 * @date 2015-3-7����2:23:24
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
