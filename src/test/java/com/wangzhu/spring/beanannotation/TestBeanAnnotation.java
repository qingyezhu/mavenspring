package com.wangzhu.spring.beanannotation;

import org.junit.Test;

import com.wangzhu.spring.beanannotation.injection.service.InjectionService;
import com.wangzhu.spring.beanannotation.javabased.Store;
import com.wangzhu.spring.beanannotation.multibean.BeanInvoker;
import com.wangzhu.spring.test.base.UnitTestBase;

public class TestBeanAnnotation extends UnitTestBase {

	public TestBeanAnnotation() {
		super("classpath:spring-beanannotation.xml");
	}

	@Test
	public void testBeanAnnotation() {
		BeanAnnotation beanAnnotation1 = this.getBean("myBeanAnnotation");
		beanAnnotation1.say("this is a test beanannotation");

		BeanAnnotation beanAnnotation2 = this.getBean("myBeanAnnotation");

		beanAnnotation1.printHashCode();
		beanAnnotation2.printHashCode();
	}

	@Test
	public void testAutowired() {
		InjectionService service = super.getBean("injectionServiceImpl");
		service.save("this is a test autowired!");
	}

	@Test
	public void testMultiBean() {
		BeanInvoker invoker = super.getBean("beanInvoker");
		invoker.say();
	}

	@Test
	public void test() {
		Store store = this.getBean("store");
		System.out.println(store.getClass().getName());

		this.getBean("myDriverManager");
	}

	@Test
	public void testInitDestry(){
		//测试init和destry方法
		this.getBean("beanLifeCycle");
	}
}
