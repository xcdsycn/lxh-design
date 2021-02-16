package com.lxh.design.facade;

/**
 * @Description 外观类，
 * <p>
 * 1. 其实就是代理关系，这个外观类，使用其他类来做事，但是外面使用的不知道
 * 2. 这是封装的另一种表现形式
 * 3. 门面模式(或外观模式)隐藏系统的复杂性，并为客户端提供一个客户端可以访问系统的接口。
 * 4. 这种类型的设计模式属于结构模式，
 * 5. 因为此模式为现有系统添加了一个接口以隐藏其复杂性。
 * </p>
 * <p>
 * 1. 门面模式涉及一个类(ShapeFacade)，
 * 2. 它提供客户端所需的简化方法和委托调用现有系统类的方法。
 * <p>
 * 《作用》 不能对一类接口进行扩充，可以通过组合的方法，使用不同的类中的方法，经过组合，具有一定的功能集合
 * 《Facade》的作用，一般都是使用某些类的功能，而不改变其功能，也就是做服务的编排
 * @Author lxh
 * @Date 2021/2/8 18:55
 **/
public class ShapeFacade {

    // 这种组织方式，会使属笥不断增加，看代理的类有多少
    private Shape circle;

    private Shape rectangle;

    private Shape square;

    /**
     * 构建 及 初始化的方式有很多重，比如注入等
     */
    public ShapeFacade() {
        circle = new Circle();
        this.rectangle = new Rectangle();
        this.square = new Square();
    }

    public void drawCircle() {
        circle.draw();
    }

    public void drawRectangle() {
        rectangle.draw();
    }

    public void drawSquare() {
        square.draw();
    }

}
