package com.lxh.design.prototype;

/**
 * @Description 原型模式
 * <p>
 * 1. 原型模式指在创建重复对象的同时保持性能。
 * 2. 这种类型的设计模式属于创建模式，因为此模式提供了创建对象的最佳方法之一。
 * </p>
 * <p>
 * 1. 这个模式涉及实现一个原型接口，它只创建当前对象的克隆。
 * 2. 有时直接创建对象时使用这种模式是昂贵的。
 * 3. 例如，在昂贵的数据库操作之后创建对象。因此我们可以缓存对象，在下一个请求时返回其克隆，并在需要时更新数据库，从而减少数据库调用。
 * </p>
 * <p>
 *     核心是，利用clone避免每次调用数据库对象，避免网络请求，将其放于内存中，需要的时候clone出来使用
 * </p>
 * @Author lxh
 * @Date 2021/2/16 19:43
 **/
public class PrototypePatternDemo {

    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape clonedShape = ShapeCache.getShape("1");
        System.out.println("Shape: " + clonedShape.getType());

        Shape clonedShape2 = ShapeCache.getShape("2");
        System.out.println("Shape: " + clonedShape2.getType());

        Shape clonedShape3 = ShapeCache.getShape("3");
        System.out.println("Shape: " + clonedShape3.getType());
    }
}
