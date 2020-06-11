package com.wangzhu.generic;

import com.wangzhu.utils.GenericTool;

/**
 * Created by wang.zhu on 2020-05-27 10:57.
 **/
public abstract class AbstractServiceAV2<L, R> extends AbstractServiceA<L, R> {

    @Override
    protected void init() {
        super.init();

        GenericTool.printClass1(getClass());
        GenericTool.printClass2(getClass());
        System.out.println("-----AbstractServiceAV2-------");
    }
}
