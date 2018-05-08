package com.wangzhu.serial;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by wangzhu on 2018/5/8 下午7:00.
 */
public class Fruit {
    private String name;
    private String desc;

    public Fruit() {

    }

    public Fruit(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
