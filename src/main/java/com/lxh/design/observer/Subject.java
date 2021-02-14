package com.lxh.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 被观察对象 抽象类
 * <p>
 *     1. 需要定义属性，而非常量
 *     2. 需要定义好算法框架，利于代码重用
 *     3. subject 是一个被观察的对象，唯一
 *     4. 应该可以新增或删除观察者
 *     5. 注意与发布订阅的区别
 * </p>
 * @Author lxh
 * @Date 2021/2/14 20:59
 **/
public class Subject {
    private List<Observer> observerList = new ArrayList<>();

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    public void notifyAllObservers() {
        observerList.forEach(Observer::update);
    }
}
