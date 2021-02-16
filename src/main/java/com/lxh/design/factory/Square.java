package com.lxh.design.factory;

/**
 * @Description 方形
 * @Author lxh
 * @Date 2021/2/16 20:34
 **/
public class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Square draw method");
    }
}
