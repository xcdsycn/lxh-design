package com.lxh.design.facade;

/**
 * @Description 具体实现类
 * @Author lxh
 * @Date 2021/2/8 18:54
 **/
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("==> Rectangle Square ...");
    }
}
