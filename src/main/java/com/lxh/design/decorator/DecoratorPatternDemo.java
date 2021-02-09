package com.lxh.design.decorator;

/**
 * @Description 使用装饰器
 * @Author lxh
 * @Date 2021/2/8 19:31
 **/
public class DecoratorPatternDemo {

    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(new Circle());

        Shape redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Circle 具有一般颜色 ");
        circle.draw();

        System.out.println("红圈的Circle");
        redCircle.draw();

        System.out.println("红边 的 Rectangle");
        redRectangle.draw();

	}
}
