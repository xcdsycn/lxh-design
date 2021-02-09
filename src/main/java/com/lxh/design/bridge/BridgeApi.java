package com.lxh.design.bridge;

/**
 * @Description 桥接模式 将定义与其实现分离。 它是一种结构模式
 * <p>
 * 桥接（Bridge）模式涉及充当桥接的接口。桥接使得具体类与接口实现者类无关。<br>
 * </p>
 * <p>
 * 当需要将抽象与其实现去耦合时使用桥接解耦（分离），使得两者可以独立地变化。
 * 这种模式涉及一个接口，作为一个桥梁，使得具体类的功能独立于接口实现类。
 * 两种类型的类可以在结构上改变而不彼此影响。
 * </p>
 * 这两种类型的类可以改变但不会影响对方。
 * @Author lxh
 * @Date 2021/2/9 16:32
 **/
public interface BridgeApi {
    // 这个是桥实现者接口
    void drawCircle(int radius, int x, int y);
}
