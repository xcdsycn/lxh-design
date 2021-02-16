package com.lxh.design.factory;

/**
 * @Description 矩形
 * @Author lxh
 * @Date 2021/2/16 20:34
 **/
public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Rectangle draw method");
    }
}
