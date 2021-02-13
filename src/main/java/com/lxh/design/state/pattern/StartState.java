package com.lxh.design.state.pattern;

/**
 * @Description 开始状态
 * @Author lxh
 * @Date 2021/2/9 18:12
 **/
public class StartState implements State{

    @Override
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "Start State";
    }
}
