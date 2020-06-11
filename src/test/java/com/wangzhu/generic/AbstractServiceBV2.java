package com.wangzhu.generic;

import com.wangzhu.spring.bean.BeanScope;
import com.wangzhu.utils.GenericTool;

/**
 * Created by wang.zhu on 2020-06-05 11:50.
 **/
public abstract class AbstractServiceBV2 extends AbstractServiceB<BeanScope, Integer> {

    @Override
    public void init() {
        super.init();

        GenericTool.printClass1(getClass());
        GenericTool.printClass2(getClass());
        System.out.println("-----AbstractServiceBV2-------");
    }
}
