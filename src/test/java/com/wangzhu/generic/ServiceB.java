package com.wangzhu.generic;

import com.wangzhu.spring.bean.BeanScope;
import com.wangzhu.utils.GenericTool;

/**
 * Created by wang.zhu on 2020-05-27 11:07.
 **/
public class ServiceB extends AbstractServiceB<BeanScope, Integer> implements IServiceB<BeanScope, Integer> {

    /**
     * 只要实现了接口，才可以通过getGenericInterfaces/getInterfaces的获取其范型
     */
    public void init() {
        super.init();
        GenericTool.printClass1(getClass());
        GenericTool.printClass2(getClass());
        System.out.println("-----ServiceB----");

        GenericTool.printInterface1(getClass());
        GenericTool.printInterface2(getClass());
        System.out.println("ServiceB end");
    }
}
