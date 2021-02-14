package com.lxh.design.template;

/**
 * @Description Game模板类
 * <p>
 *     1. 涉及到模板及策略的模式，都以抽象类开始
 *     2. 具体类，实现这些抽象的方法
 *     3. final方法是具体的调用业务逻辑
 * </p>
 * @Author lxh
 * @Date 2021/2/14 17:39
 **/
public abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract  void endPlay();

    /**
     * template method
     */
    public final void play() {
        // initialize the game
        initialize();

        // start game
        startPlay();

        // end game
        endPlay();
    }
}
