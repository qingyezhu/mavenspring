package com.wangzhu.serial;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by wangzhu on 2018/5/8 下午7:56.
 */
public class Dog extends Animal {
    private String show;
    private transient Fruit fruit;

    public Dog(String name, int age, String show) {
        super(name, age);
        this.show = show;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
