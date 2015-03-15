package com.wangzhu.spring.autowiring;

import org.junit.Test;

import com.wangzhu.spring.test.base.UnitTestBase;

/**
 * 自动装配<br/>
 * byName：需要无参构造方法<br/>
 * byType：需要无参构造方法且类型唯一，直接指定class即可，否则抛出异常。<br/>
 * constructor：需要类中提供相应的构造方法，当只有一个同类型的Bean时，直接调用对应类型的有参构造方法；<br/>
 * 当有多个同类型的Bean时，根据构造方法中形参名进行匹配，若无，直接调用无参构造方法；否则抛出异常。<br/>
 * 
 * @author wangzhu
 * @date 2015-3-7下午2:22:32
 * 
 */
public class TestAutoWiring extends UnitTestBase {
	public TestAutoWiring() {
		super("classpath*:spring-autowiring.xml");
	}

	@Test
	public void testAutoWiring() {
		AutoWiringService service = this.getBean("autoWiringService");
		service.say("this is a test autowire!");
	}
}
