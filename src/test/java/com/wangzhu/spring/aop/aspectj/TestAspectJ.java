package com.wangzhu.spring.aop.aspectj;

import com.wangzhu.spring.aop.aspectj.biz.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.wangzhu.spring.aop.aspectj.biz.AspectJBiz;
import com.wangzhu.spring.test.base.UnitTestBase;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestAspectJ extends UnitTestBase {

	public TestAspectJ() {
		super("classpath:spring-aop-aspectj.xml");
	}

//	@Test
//	public void testAspectJ() {
//		AspectJBiz biz = super.getBean("aspectJBiz");
//		System.out.println(biz.save("testAspectJ"));
//	}

	@Test
	public void testUserServce(){
		IUserService userService = super.getBean(IUserService.class);
		userService.queryUser("100");
	}
}
