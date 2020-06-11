package com.wangzhu.generic;

import com.wangzhu.spring.bean.BeanScope;
import com.wangzhu.utils.GenericTool;

/**
 * Created by wang.zhu on 2020-06-05 11:52.
 **/
public class ServiceBV2 extends AbstractServiceBV2 implements IServiceB<BeanScope, Integer>, Comparable<BeanScope>{
    @Override
    public void init() {
//        super.init();
//
//        GenericTool.printClass1(getClass());
//        GenericTool.printClass2(getClass());
//        System.out.println("-----ServiceBV2----");

//        GenericTool.printInterface1(getClass());
        GenericTool.printInterface2(getClass());
        System.out.println("ServiceBV2 end");
    }


    @Override
    public int compareTo(BeanScope o) {
        return 0;
    }
}
