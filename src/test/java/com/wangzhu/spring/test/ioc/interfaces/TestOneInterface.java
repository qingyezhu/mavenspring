package com.wangzhu.spring.test.ioc.interfaces;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.wangzhu.spring.ioc.interfaces.OneInterface;
import com.wangzhu.spring.test.base.UnitTestBase;

/**
 * 
 * @author wangzhu
 * @date 2015-3-7обнГ2:24:57
 * 
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestOneInterface extends UnitTestBase {

	public TestOneInterface() {
		super("classpath*:spring-ioc.xml");
	}

	@Test
	public void testsay() {
		OneInterface oneInterface = super.getBean("oneInterface");
		oneInterface.say("This is a test.");
	}

}
