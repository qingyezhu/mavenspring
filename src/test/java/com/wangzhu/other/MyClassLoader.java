package com.wangzhu.other;

import java.io.File;
import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by wang.zhu on 2021-05-26 22:32.
 **/
public class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println(name);
        final String classFilePath = name + ".class";
        final File classFile = new File(classFilePath);
        Class<?> clazz = null;
        if (classFile.exists()) {
            try (FileChannel fileChannel = new FileInputStream(classFile).getChannel()) {
                MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
                final byte[] buf = mappedByteBuffer.array();
                //进行解密
                //todo
                clazz = defineClass(name, buf, 0, buf.length);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return clazz;
    }
}
