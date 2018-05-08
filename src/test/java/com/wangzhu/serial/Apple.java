package com.wangzhu.serial;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created by wangzhu on 2018/5/8 下午7:40.
 */
public class Apple extends Fruit implements Serializable {
    private String weight;

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Apple(String name, String desc, String weight) {
        super(name, desc);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
