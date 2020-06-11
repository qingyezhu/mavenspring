package com.wangzhu.generic;

import com.wangzhu.utils.GenericTool;

/**
 * Created by wang.zhu on 2020-05-27 10:56.
 **/
public abstract class AbstractServiceA<L, R> {

    protected void init() {
        GenericTool.printClass1(getClass());
        GenericTool.printClass2(getClass());
        System.out.println("-----AbstractServiceA-------");
    }

}
