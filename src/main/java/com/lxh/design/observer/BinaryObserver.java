package com.lxh.design.observer;

/**
 * @Description 观察者 参见 {@link HexObserver}
 * @Author lxh
 * @Date 2021/2/14 21:03
 **/
public class BinaryObserver extends Observer{

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String :" + Integer.toBinaryString(subject.getState()));
    }
}
