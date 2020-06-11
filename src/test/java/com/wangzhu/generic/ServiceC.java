package com.wangzhu.generic;

import com.wangzhu.spring.bean.BeanScope;
import com.wangzhu.utils.GenericTool;

/**
 * Created by wang.zhu on 2020-05-27 11:28.
 **/
public class ServiceC implements IServiceC<BeanScope, Long> {
    @Override
    public void init() {
        GenericTool.printInterface1(getClass());
        GenericTool.printInterface2(getClass());
    }
}
