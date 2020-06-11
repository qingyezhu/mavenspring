package com.wangzhu.utils;

import com.wangzhu.generic.IServiceB;
import com.wangzhu.spring.bean.BeanScope;
import org.springframework.core.ResolvableType;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * Created by wang.zhu on 2020-05-27 11:21.
 **/
public abstract class GenericTool {
    public static void printClass1(final Class<?> clazz) {
        final Type type = clazz.getGenericSuperclass();
        System.out.println(type);
        if (type instanceof ParameterizedType) {
            final ParameterizedType parameterizedType = (ParameterizedType) type;
            final Type[] parameterizedTypeActualTypeArguments = parameterizedType.getActualTypeArguments();
            System.out.println(Arrays.toString(parameterizedTypeActualTypeArguments));
        }
        System.out.println("printClass1--" + clazz);
    }

    public static void printClass2(final Class<?> clazz) {
        final ResolvableType resolvableType = ResolvableType.forClass(clazz).getSuperType();
        System.out.println(Arrays.toString(resolvableType.getGenerics()));
        System.out.println("printClass2--" + clazz);
    }

    public static void printInterface1(final Class<?> clazz) {
        final Type[] types = clazz.getGenericInterfaces();
        System.out.println(Arrays.toString(types));
        for (final Type type : types) {
            final ParameterizedType parameterizedType = (ParameterizedType) type;
            final Type[] parameterizedTypeActualTypeArguments = parameterizedType.getActualTypeArguments();
            System.out.println(Arrays.toString(parameterizedTypeActualTypeArguments));
        }
        System.out.println("printInterface1--" + clazz);
    }

    public static void printInterface2(final Class<?> clazz) {
        final ResolvableType[] resolvableTypes = ResolvableType.forClass(clazz).getInterfaces();
        for (final ResolvableType resolvableType : resolvableTypes) {

            System.out.println(resolvableType);
            if(resolvableType.getType() instanceof IServiceB){
                System.out.println("dd");
            }

            System.out.println(Arrays.toString(resolvableType.getGenerics()));

            for (final ResolvableType subResolvableType : resolvableType.getGenerics()) {
                System.out.println(subResolvableType.getRawClass());
            }
        }
        System.out.println("printInterface2--" + clazz);
    }

}
