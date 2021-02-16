package com.lxh.design.prototype;

/**
 * @Description 这只是模板类，用于clone对象
 * @Author lxh
 * @Date 2021/2/16 19:33
 **/
public class Rectangle extends Shape{

    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
