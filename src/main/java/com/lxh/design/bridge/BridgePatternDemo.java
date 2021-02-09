package com.lxh.design.bridge;

/**
 * @Description 主类，用来营造使用场景
 * @Author lxh
 * @Date 2021/2/9 16:53
 **/
public class BridgePatternDemo {
    public static void main(String[] args) {
        AbstractShape redCircle = new Circle(new RedCircle(),100,100,0);
        AbstractShape greenCircle = new Circle(new GreenCircle(),100,100,0);

        redCircle.draw();
        greenCircle.draw();
    }
}
