package com.lxh.design.memo;

/**
 * @Description 备忘录项
 * <p>
 *     这里只有一个项目状态，可以扩充其属性，记录更多的内容，如MYSQL的Binlog一样，做到redo的功能
 * </p>
 * @Author lxh
 * @Date 2021/2/14 21:22
 **/
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
