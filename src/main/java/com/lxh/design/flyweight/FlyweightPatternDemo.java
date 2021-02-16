package com.lxh.design.flyweight;

/**
 * @Description 享元模式
 * <p>
 * 1. 享元模式(Flyweight Pattern)主要用于减少创建的对象数量，并减少内存占用并提高性能。
 * 2. 这种类型的设计模式属于结构模式，因为该模式提供了减少对象计数的方法，从而改善应用的对象结构。
 * </p>
 * <p>
 * 1. 享元模式(Flyweight Pattern)尝试通过存储已经存在的类似对象以重用，并在找不到匹配的对象时创建新对象。
 * 2. 我们将通过绘制不同位置的20个圆圈来演示这种模式，但是这里只创建5个对象。
 * 3. 只有5种颜色可用，因此color属性用于检查已经存在的Circle对象。
 * </p>
 * <p>
 *     1. 注意这里是绘制20个圆，是调用圆的方法来绘制，而不是创建20圆的实例
 *     2. 这就有点像前端的控件，控件的类型有数量上的限制
 *     3. 通过缓存固定的对象数量的对象，然后取出来后，修改其属性，然后调用其方法完成绘制
 *     4. 其核心思想，1）是缓存的思想，缓存中有的不需要创建 2）取出对象，修改其属性，调用相应的方法，相当于修改输入函数的参数修改
 *     5. 本例中，其实，可以只创建一个对象，其他的对象都通过修改其属性完成绘制功能
 * </p>
 * @Author lxh
 * @Date 2021/2/16 18:45
 **/
public class FlyweightPatternDemo {
    private static final String[] colors = {"Red", "Green", "Blue", "White", "Black"};


    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            // 这个例子就通过修改颜色，只创建一个对象来实现的调用
            Circle circle = (Circle) ShapeFactory.getCircle("Red");
            circle.setColor(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }
    }

    private static String getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

    private static int getRandomX() {
        return (int) (Math.random() * 100);
    }

    private static int getRandomY() {
        return (int) (Math.random() * 100);
    }


}
