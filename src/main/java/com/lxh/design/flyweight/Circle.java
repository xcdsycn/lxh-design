package com.lxh.design.flyweight;

/**
 * @Description 被缓存的需要创建的对象
 * @Author lxh
 * @Date 2021/2/16 18:40
 **/
public class Circle implements Shape{
    private String color;
    private int x;
    private int y;
    private int radius;

    public void setColor(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "color='" + color + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                '}';
    }
}
