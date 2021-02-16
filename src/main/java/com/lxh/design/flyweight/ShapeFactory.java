package com.lxh.design.flyweight;

import java.util.HashMap;

/**
 * @Description 形状工厂
 * <p>
 *     1. 工厂中有缓存
 *     2. 每创建一个，就放入缓存
 *     3. 每次取的时候，先从缓存中取，没有就创建
 * </p>
 * @Author lxh
 * @Date 2021/2/16 18:42
 **/
public class ShapeFactory {
    private static final HashMap<String,Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle) circleMap.get(color);

        if(null == circle) {
            circle = new Circle();
            circle.setColor(color);

            circleMap.put(color,circle);
            System.out.println("Creating circle of color: " + color);
        }
        return  circle;
    }
}
