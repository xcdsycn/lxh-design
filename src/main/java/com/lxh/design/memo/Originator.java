package com.lxh.design.memo;

/**
 * @Description 当前对象或者叫状态对象
 * <p>
 *     1. 在这个对象里，可以生成备忘录项
 *     2. 可以从备忘录项里，得到自己能识别的属性，起到翻译的作用
 * </p>
 * @Author lxh
 * @Date 2021/2/14 21:24
 **/
public class Originator {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public Memento saveStateToMemento(){
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        this.state = memento.getState();
    }
}
