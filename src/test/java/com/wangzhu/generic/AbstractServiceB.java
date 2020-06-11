package com.wangzhu.generic;

import com.wangzhu.utils.GenericTool;
import org.springframework.core.ResolvableType;

/**
 * Created by wang.zhu on 2020-05-27 11:18.
 **/
public abstract class AbstractServiceB<L, R> implements IServiceB<L, R> {

    protected Class<L> clazz;
    @Override
    public void init() {
        GenericTool.printClass1(getClass());
        GenericTool.printClass2(getClass());
        System.out.println("-----AbstractServiceB----");
        GenericTool.printInterface1(getClass());
        GenericTool.printInterface2(getClass());
        System.out.println("AbstractServiceB end");
//

        final ResolvableType resolvableType = ResolvableType.forClass(getClass()).getSuperType();

        System.out.println(resolvableType.getGeneric(0).getClass());
        System.out.println(resolvableType.getGeneric(0).getRawClass());

        @SuppressWarnings("unchecked")
        Class<L> clazz = (Class<L>)resolvableType.getGeneric(0).getRawClass();
        this.clazz = clazz;

        System.out.println(this.clazz);
    }

}
