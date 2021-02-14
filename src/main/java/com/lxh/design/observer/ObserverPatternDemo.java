package com.lxh.design.observer;

/**
 * @Description 观察者模式
 * <p>
 *     1. 主要定义了状态或属性的变化，如何传播到相关的观察者
 *     2. 每个观察者，都观察到相同的或被设置好的 {@link Subject}，改变Subject会，subject会根据注册的观察者，一一通知
 * </p>
 * <p>
 *     1. 观察者模式在对象之间存在一对多关系时使用，例如，如果一个对象被修改，它的依赖对象将被自动通知。
 *     2. 观察者模式属于行为模式类别。
 * </p>
 * @Author lxh
 * @Date 2021/2/14 21:06
 **/
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change : 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
