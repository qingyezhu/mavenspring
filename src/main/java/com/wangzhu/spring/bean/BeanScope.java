package com.wangzhu.spring.bean;

/**
 * Bean的作用域：<br/>
 * singleton：单例，指一个Bean容器中只存在一份<br/>
 * prototype：每次请求（每次使用）创建新的实例，Destroy方式不生效<br/>
 * 
 * @author wangzhu
 * @date 2015-3-7上午1:06:27
 * 
 */
public class BeanScope {
	public void say() {
		System.out.println("BeanScope say: " + this.hashCode());
	}
}
