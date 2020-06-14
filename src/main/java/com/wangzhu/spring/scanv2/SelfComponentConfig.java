package com.wangzhu.spring.scanv2;

import com.wangzhu.service.SelfService;
import com.wangzhu.spring.registrar.SelfComponentConfigV2;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by wang.zhu on 2020-06-13 21:58.
 **/
@SelfComponentScan(basePackages = {"com.wangzhu.spring.scan", "com.wangzhu.spring.service.scanv2"}, basePackageClasses = {SelfService.class})
@Configuration
//@Import(SelfComponentConfigV2.class)
public class SelfComponentConfig {
}
