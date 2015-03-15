package com.wangzhu.spring.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Bean���������ڡ�ʵ�ֽӿڡ�����Beanʱָ����������ʱ������ʵ�ַ�������Ĭ��ȫ�֡�
 * 
 * @author wangzhu
 * @date 2015-3-7����1:37:11
 * 
 */
public class BeanLifeCycle implements InitializingBean, DisposableBean {

	public void start() {
		System.out.println("BeanLifeCycle start");
	}

	public void stop() {
		System.out.println("BeanLifeCycle stop");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("BeanLifeCycle afterPropertiesSet");
	}

	public void destroy() throws Exception {
		System.out.println("BeanLifeCycle destroy");
	}

	public void defaultInit() {
		System.out.println("BeanLifeCycle defaultInit");
	}

	public void defaultDestroy() {
		System.out.println("BeanLifeCycle defaultDestroy");
	}
}
