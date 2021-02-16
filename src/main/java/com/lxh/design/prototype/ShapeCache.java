package com.lxh.design.prototype;

import java.util.Hashtable;

/**
 * @Description TODO
 * @Author lxh
 * @Date 2021/2/16 19:35
 **/
public class ShapeCache {
    /**
     * 1. Hashtable线程安全，比HashMap性能低，由于JDK的改进，可以有相应的并发数据结构
     * 2. Hashtable 不允许Key Value为null，这可以作为一个技巧，不允许Null K V
     * 3. {@link Hashtable} 继承于 Dictionary
     */
    private static Hashtable<String, Shape> shapeMap = new Hashtable<>();

    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        // 这一步执行Clone操作
        return (Shape) cachedShape.clone();
    }

    /**
     * 1. 预先创建三种类型的模板在缓存中
     * 2. 需要的时候clone出来一个就可以了
     */
    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(),circle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(),square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(), rectangle);
    }
}
