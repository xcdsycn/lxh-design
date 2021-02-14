package com.lxh.design.template;

/**
 * @Description 具体方法
 * @Author lxh
 * @Date 2021/2/14 17:42
 **/
public class Cricket extends Game{
    @Override
    void initialize() {
        System.out.println("Cricket 游戏初始化完成毕，可以开始玩了！");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket 游戏开始，尽情玩耍吧");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket 游戏结束了");
    }
}
