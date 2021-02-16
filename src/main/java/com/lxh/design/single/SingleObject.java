package com.lxh.design.single;

/**
 * @Description 这个是最简单的单例模式
 * <p>
 *     可见其他的模式也有其他的变种，需要不断的去观察，去了解其他设计模式，还可以总结自己的设计模式
 * </p>
 * @Author lxh
 * @Date 2021/2/16 20:27
 **/
public class SingleObject {

    private static SingleObject instance = new SingleObject();

    private SingleObject() {}

    public static SingleObject getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello, this is single object Pattern");
    }
}
