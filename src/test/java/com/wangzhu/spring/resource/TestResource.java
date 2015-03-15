package com.wangzhu.spring.resource;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.wangzhu.spring.test.base.UnitTestBase;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestResource extends UnitTestBase {

	public TestResource() {
		super("classpath:spring-resource.xml");
	}

	@Test
	public void testResource() {
		MyResource resource = this.getBean("myResource");
		try {
			resource.resourceByPath("classpath:resource_config.txt");
			resource.resourceByPath("file:E:/programes/eclipse_jee_juno/workspace2/mavenspring/src/main/resources/resource_config.txt");
			resource.resourceByPath("url:http://www.cnblogs.com/xiaoxian1369/p/4320423.html");
			resource.resourceByPath("resource_config.txt");
			// 根据ApplicationContext的产生路径
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
