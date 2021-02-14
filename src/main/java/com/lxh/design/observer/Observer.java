package com.lxh.design.observer;

/**
 * @Description 抽象类中，可以定义属性或抽象方法
 * <p>
 *     需要定义被观察者，与回调（被通知）方法
 * </p>
 * @Author lxh
 * @Date 2021/2/14 21:00
 **/
public abstract class Observer {

    protected Subject subject;

    public abstract  void update();
}
