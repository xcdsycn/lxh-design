package com.lxh.design.decorator;


/**
 * @Description 具体实现类
 * @Author lxh
 * @Date 2021/2/8 18:54
 **/
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("==> Rectangle draw ...");
    }
}
