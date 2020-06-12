package com.wangzhu.service;

/**
 * Created by wang.zhu on 2020-06-12 16:23.
 **/
public class SelfBService {

    private SelfDService selfDService;

    public void setSelfDService(SelfDService selfDService) {
        this.selfDService = selfDService;
    }

    public void print() {
        System.out.println("SelfBService " + System.currentTimeMillis());
        selfDService.print();
    }
}
