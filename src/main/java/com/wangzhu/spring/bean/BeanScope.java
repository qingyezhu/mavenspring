package com.wangzhu.spring.bean;

/**
 * Bean��������<br/>
 * singleton��������ָһ��Bean������ֻ����һ��<br/>
 * prototype��ÿ������ÿ��ʹ�ã������µ�ʵ����Destroy��ʽ����Ч<br/>
 * 
 * @author wangzhu
 * @date 2015-3-7����1:06:27
 * 
 */
public class BeanScope {
	public void say() {
		System.out.println("BeanScope say: " + this.hashCode());
	}
}
