package com.lxh.design.observer;

/**
 * @Description 观察者
 * <p>
 *     1. 设置好被观察的对象
 *     2. 注册到这个对象的观察者列表
 *     3. 实现被通知时，需要被观察对象调用的方法
 * </p>
 * @Author lxh
 * @Date 2021/2/14 21:05
 **/
public class HexObserver extends Observer{
    public HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String:" + Integer.toHexString(subject.getState()));
    }
}
