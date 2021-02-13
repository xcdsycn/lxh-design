package com.lxh.design.state.pattern;

/**
 * @Description 因为是根据状态影响行为，所以一个行为获取状态需要从上下文中获取
 *
 * 然后根据状态有相应的行为
 * @Author lxh
 * @Date 2021/2/9 18:09
 **/
public interface State {
    void doAction(Context context);
}
