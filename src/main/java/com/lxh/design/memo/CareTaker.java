package com.lxh.design.memo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 备忘录持有者
 * <p>
 *     在这里可以记录更多详细的信息，可以作为状态变换日志，甚至都可以回放
 * </p>
 * @Author lxh
 * @Date 2021/2/14 21:26
 **/
public class CareTaker {

    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento memento) {
        this.mementoList.add(memento);
    }

    public Memento get(int index) {
        return this.mementoList.get(index);
    }
}
