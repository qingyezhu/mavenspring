package com.wangzhu.generic;

import com.wangzhu.utils.GenericTool;

/**
 * Created by wang.zhu on 2020-05-27 10:58.
 **/
public class ServiceA extends AbstractServiceAV2<Integer, String> {
    public void init(){
        super.init();

        GenericTool.printClass1(getClass());
        GenericTool.printClass2(getClass());
        System.out.println("-----ServiceA-------");
    }
}
