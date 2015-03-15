package com.wangzhu.spring.autowiring;

import org.junit.Test;

import com.wangzhu.spring.test.base.UnitTestBase;

/**
 * �Զ�װ��<br/>
 * byName����Ҫ�޲ι��췽��<br/>
 * byType����Ҫ�޲ι��췽��������Ψһ��ֱ��ָ��class���ɣ������׳��쳣��<br/>
 * constructor����Ҫ�����ṩ��Ӧ�Ĺ��췽������ֻ��һ��ͬ���͵�Beanʱ��ֱ�ӵ��ö�Ӧ���͵��вι��췽����<br/>
 * ���ж��ͬ���͵�Beanʱ�����ݹ��췽�����β�������ƥ�䣬���ޣ�ֱ�ӵ����޲ι��췽���������׳��쳣��<br/>
 * 
 * @author wangzhu
 * @date 2015-3-7����2:22:32
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
