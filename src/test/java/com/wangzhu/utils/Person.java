package com.wangzhu.utils;

import org.openjdk.jol.info.ClassLayout;

/**
 * Created by wang.zhu on 2021-04-27 00:38.
 **/
public class Person {
    private String name;
    private int age;
    private boolean flag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void print(){
        System.out.println(ClassLayout.parseInstance(this).toPrintable());
    }
}
