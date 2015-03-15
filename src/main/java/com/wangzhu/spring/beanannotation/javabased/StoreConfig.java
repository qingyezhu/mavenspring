package com.wangzhu.spring.beanannotation.javabased;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:config.xml")
public class StoreConfig {
	@Value("${url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${password}")
	private String password;

	@Bean(name = "store", initMethod = "init", destroyMethod = "destroy")
	public StringStore getStringStore() {
		// 当没有指定name时，默认名为方法名，即getStringStore
		return new StringStore();
	}

	@Bean
	public MyDriverManager myDriverManager() {
		return new MyDriverManager(url, username, password);
	}
}
