package com.wangzhu.spring.registrar;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 扫描到Configuration注解，就可以<br/>
 * Created by wang.zhu on 2020-06-12 14:35.
 **/
@Configuration
@ComponentScan({"com.wangzhu.service", "com.wangzhu.spring.registrar"})
//@Import(SelfServiceConfig.class)
public class SelfBeanConfig {

}
