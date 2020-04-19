package com.wangzhu.utils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

/**
 * Created by wang.zhu on 2020-01-10 11:14.
 **/
public class ReflectionUtil {

    public static Method[] getMethods(Class<?> clazz) {
        Method[] methods = null;
        if (clazz.isInterface()) {
            methods = clazz.getMethods();
            for (final Method ifcMehod : methods) {
                System.out.println(ifcMehod.getName() + "==1=" + Modifier.isInterface(clazz.getModifiers()));
                System.out.println(ifcMehod.getName() + "==1=" + Modifier.isAbstract(clazz.getModifiers()));
            }

        }

        for (final Class<?> ifc : clazz.getInterfaces()) {
            for (final Method ifcMehod : ifc.getMethods()) {
                System.out.println(ifcMehod.getName() + "===" + Modifier.isInterface(ifc.getModifiers()));
                System.out.println(ifcMehod.getName() + "===" + Modifier.isAbstract(ifc.getModifiers()));
            }
        }
        return null;
    }
}
