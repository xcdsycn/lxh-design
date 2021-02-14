package com.lxh.design.observer;

/**
 * @Description 观察者 参见 {@link HexObserver}
 * @Author lxh
 * @Date 2021/2/14 21:05
 **/
public class OctalObserver extends Observer{
    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Octal String:" + Integer.toOctalString(subject.getState()));
    }
}
