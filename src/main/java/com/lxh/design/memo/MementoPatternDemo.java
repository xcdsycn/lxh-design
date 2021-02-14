package com.lxh.design.memo;

/**
 * @Description 备忘录模式
 * <p>
 *     1. 备忘录模式(Memento Pattern)用来恢复一个对象的状态到以前的状态。
 *     2. 备忘录模式下属于行为模式的类别。
 * </p>
 * @Author lxh
 * @Date 2021/2/14 21:27
 **/
public class MementoPatternDemo {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        originator.setState("Sate #1");
        originator.setState("Sate #2");
        // 记录状态
        careTaker.add(originator.saveStateToMemento());

        originator.setState("Sate #3");
        // 记录状态
        careTaker.add(originator.saveStateToMemento());

        originator.setState("Sate #4");
        System.out.println("Current State:  " + originator.getState());

        // 以下返回被记录的两个状态
        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("First saved state: " + originator.getState());

        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("Second saved state: " + originator.getState());


    }
}
