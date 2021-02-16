package com.lxh.design.factory;

/**
 * @Description 工厂设计模式
 * <p>
 *     在工厂模式中，我们没有创建逻辑暴露给客户端创建对象，并使用一个通用的接口引用新创建的对象。
 *     一切设计模式，都离不开接口与抽象类，因此，在设计自己的工程的时候，需要首先考虑到这种工具，然后考虑如何组织他们
 * </p>
 * @Author lxh
 * @Date 2021/2/16 20:37
 **/
public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape("circle");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("square");
        shape2.draw();

        Shape shape3 = shapeFactory.getShape("rectangle");
        shape3.draw();
    }
}
