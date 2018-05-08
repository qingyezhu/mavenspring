package com.wangzhu.serial;

import com.wangzhu.TestBase;
import org.junit.Before;
import org.junit.Test;

import java.io.*;


/**
 * Created by wangzhu on 2018/5/8 下午7:01.
 */
public class SerialTest extends TestBase {

    @Before
    public void init() {
        File file = new File("logs");
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    @Test
    public void fruit() {
        //没有实现Serializable，则无法序列化
        Fruit fruit = new Fruit("", "");
        fruit.setName("水果");
        fruit.setDesc("好东西");
        System.out.println("序列化前：" + fruit);
        final String path = "logs/fruit.log";

        output(path, fruit);
        fruit = (Fruit) input(path);
        System.out.println("序列化后：" + fruit);
    }

    @Test
    public void animal() {
        //实现Serializable，则可以序列化
        Animal animal = new Animal("", 0);
        animal.setName("动物");
        animal.setAge(1);
        System.out.println("序列化前：" + animal);
        final String path = "logs/animal.log";
        output(path, animal);

        animal = (Animal) input(path);
        System.out.println("序列化后：" + animal);
    }

    @Test
    public void testApple() {
        //当父类没有，而子类实现Serializable，则子类可以序列化，但前提是父类需要有无参构造函数，否则也不行
        Apple apple = new Apple("", "", "");
        apple.setName("苹果");
        apple.setDesc("维生素");
        apple.setWeight("重量");
        System.out.println("序列化前：" + apple);
        final String path = "logs/apple.log";
        output(path, apple);

        apple = (Apple) input(path);
        System.out.println("序列化后：" + apple);
    }

    @Test
    public void testCat() {
        Cat cat = new Cat("", 1, "");
        cat.setName("苹果");
        cat.setAge(2);
        cat.setColor("黄色");
        System.out.println("序列化前：" + cat);
        final String path = "logs/cat.log";
        output(path, cat);

        cat = (Cat) input(path);
        System.out.println("序列化后：" + cat);
    }

    @Test
    public void testDog() {
        //当序列化字段中有引用类型，若该引用对应的类没有实现Serializable，则该对象不能序列化
        //该字段直接加入修饰符transient
        Dog dog = new Dog("", 1, "");
        dog.setName("狗");
        dog.setAge(3);
        dog.setShow("狗吠");
        Fruit fruit = new Fruit("香蕉", "假的");
//        Apple apple = new Apple("苹果", "果实", "11");
        dog.setFruit(fruit);
        System.out.println("序列化前：" + dog);
        final String path = "logs/dog.log";
        output(path, dog);

        dog = (Dog) input(path);
        System.out.println("序列化后：" + dog);
    }

    void output(String path, Object obj) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Object input(String path) {
        Object obj = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            obj = ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

}
