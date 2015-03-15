package com.wangzhu.spring.beanannotation;

import org.junit.Test;

import com.wangzhu.spring.beanannotation.injection.service.InjectionService;
import com.wangzhu.spring.beanannotation.javabased.Store;
import com.wangzhu.spring.beanannotation.multibean.BeanInvoker;
import com.wangzhu.spring.test.base.UnitTestBase;

/**
 * Bean基于注解的实现【Component、Scope】
 * 
 * @author wangzhu
 * @date 2015-3-7下午4:30:55
 * 
 */
public class TestBeanAnnotation extends UnitTestBase {

	public TestBeanAnnotation() {
		super("classpath:spring-beanannotation.xml");
	}

	@Test
	public void testBeanAnnotation() {
		// 当注解Component未指定值时，则Bean的名称为该类的第一位小写，即beanAnnotation
		BeanAnnotation beanAnnotation1 = this.getBean("myBeanAnnotation");
		beanAnnotation1.say("this is a test beanannotation");

		BeanAnnotation beanAnnotation2 = this.getBean("myBeanAnnotation");

		beanAnnotation1.printHashCode();
		beanAnnotation2.printHashCode();
	}

	@Test
	public void testAutowired() {
		// autowired可以注解成员变量、成员变量的set方法，构造方法
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
}
