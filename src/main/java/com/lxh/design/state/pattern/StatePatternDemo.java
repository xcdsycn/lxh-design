package com.lxh.design.state.pattern;

/**
 * @Description 在上下文中记录当前状态，当然 上下文可以记录更多的状态信息
 *
 * 那么行为，也可以根据上下文中的状态，自由改变
 * @Author lxh
 * @Date 2021/2/9 18:14
 **/
public class StatePatternDemo {
    public static void main(String[] args) {
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);

        EndState endState = new EndState();
        endState.doAction(context);

        System.out.println(context.getState().toString());

    }
}
