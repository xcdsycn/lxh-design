package com.lxh.design.prototype;

/**
 * @Description TODO
 * @Author lxh
 * @Date 2021/2/16 19:33
 **/
public class Square extends Shape{

    public Square() {
        type = "Square";
    }

    @Override
    void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
