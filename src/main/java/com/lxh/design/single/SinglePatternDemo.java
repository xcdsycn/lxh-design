package com.lxh.design.single;

/**
 * @Description 单例模式
 * <p>
 *     单例（Singleton）模式是Java中最简单的设计模式之一。
 *     这种类型的设计模式属于创建模式，因为此模式提供了创建对象的最佳方法之一。
 *     这也是最简单的单例模式，其它的单例的实现需要明确其使用的场景
 *     有时候，这个模式也与其他创建者模式一同使用，如工厂模式等
 * </p>
 * @Author lxh
 * @Date 2021/2/16 20:29
 **/
public class SinglePatternDemo {
    public static void main(String[] args) {
        SingleObject object = SingleObject.getInstance();

        object.showMessage();
    }
}
