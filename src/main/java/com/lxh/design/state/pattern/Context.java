package com.lxh.design.state.pattern;

/**
 * @Description 用来记录状态，当然可以是多个状态的上下文
 * @Author lxh
 * @Date 2021/2/9 18:10
 **/
public class Context {

    private State state;

    public Context() {
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return this.state;
    }
}
