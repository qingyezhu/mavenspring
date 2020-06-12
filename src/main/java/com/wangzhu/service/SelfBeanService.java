package com.wangzhu.service;

/**
 * Created by wang.zhu on 2020-06-12 15:17.
 **/
public class SelfBeanService {

    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void print() {
        System.out.println("desc: ====" + getDesc());
    }
}
