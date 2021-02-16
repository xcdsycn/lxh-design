package com.lxh.design.builder;

/**
 * @Description 冷饮
 * <p>
 * 1. 原理同Burger
 * 2. 冷饮是一顿饭一项
 * 3. 冷饮是饭的一个子类
 * 4. 冷饮用瓶子装
 * </p>
 * @Author lxh
 * @Date 2021/2/16 19:56
 **/
public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }


}
