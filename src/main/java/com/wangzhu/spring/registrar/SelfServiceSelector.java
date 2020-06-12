package com.wangzhu.spring.registrar;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by wang.zhu on 2020-06-12 16:29.
 **/
public class SelfServiceSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.wangzhu.service.SelfCService"};
    }
}
