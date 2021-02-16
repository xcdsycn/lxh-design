package com.lxh.design.factory;

/**
 * @Description 工厂类
 * <p>
 *     这个工厂类中，使用了工厂方法，创建具体的对象
 * </p>
 * @Author lxh
 * @Date 2021/2/16 20:35
 **/
public class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }

        if(shapeType.equalsIgnoreCase("circle")) {
            return new Circle();
        }
        if(shapeType.equalsIgnoreCase("square")) {
            return new Square();
        }
        if(shapeType.equalsIgnoreCase("Rectangle")) {
            return new Rectangle();
        }
        return null;
    }
}
