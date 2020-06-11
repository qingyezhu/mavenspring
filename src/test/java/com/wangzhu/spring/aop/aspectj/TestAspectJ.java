package com.wangzhu.spring.aop.aspectj;

import com.wangzhu.spring.aop.aspectj.biz.IUserService;
import com.wangzhu.spring.test.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.context.event.ContextRefreshedEvent;

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
		try {
			IUserService userService1 = super.getBean("userProxy");
			userService1.queryUser("20");
		}catch (Exception e){
			e.printStackTrace();
		}

	}
}
