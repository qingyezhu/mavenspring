package com.wangzhu.spring.registrar;

import com.wangzhu.service.SelfAService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by wang.zhu on 2020-06-12 16:24.
 **/
@Configuration
@Import({SelfAService.class, SelfServiceRegistrar.class, SelfServiceSelector.class})
@ComponentScan("com.wangzhu.service")
public class SelfServiceConfig {
}
