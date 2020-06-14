package com.wangzhu.spring.scan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wang.zhu on 2020-06-13 18:18.
 **/
@Configuration
@ComponentScan("com.wangzhu.spring.scan")
@EnableSelfScan
public class SelfScanConfig {
}
