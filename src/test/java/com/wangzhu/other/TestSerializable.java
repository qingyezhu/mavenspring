package com.wangzhu.other;

import com.wangzhu.other.bean.Animal;
import com.wangzhu.other.bean.Dog;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by wang.zhu on 2021-03-08 18:00.
 **/
public class TestSerializable {


    public static void main(String[] args) throws Exception {
        final Animal animal = new Animal("", 2);
        animal.setId("动物");
        animal.setAge(1);

//        final Animal newAnimal = (Animal) demo(animal);
//        System.out.println(animal);
//        System.out.println(newAnimal);

        final Dog dog = new Dog("", 3, "");
        dog.setId("狗");
        dog.setAge(5);
        dog.setDotAction("吠叫");

        final Dog newDog = (Dog) demo(dog);
        System.out.println(dog);
        System.out.println(newDog);

    }

    private static Object demo(final Object object) throws Exception {
        final String fileName = "tmp";
        final FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);

        final FileInputStream fileInputStream = new FileInputStream(fileName);
        final ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        return objectInputStream.readObject();
    }
}
