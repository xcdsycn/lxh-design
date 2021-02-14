package com.lxh.design.template;

/**
 * @Description 具体的实现类
 * <p>
 *     实现其中定义好的抽象方法
 * </p>
 * @Author lxh
 * @Date 2021/2/14 17:44
 **/
public class Football extends Game{
    @Override
    void initialize() {
        System.out.println("Football 游戏初始化完成");
    }

    @Override
    void startPlay() {
        System.out.println("Football 游戏开始，尽情玩吧");
    }

    @Override
    void endPlay() {
        System.out.println("Football 游戏结束");
    }
}
