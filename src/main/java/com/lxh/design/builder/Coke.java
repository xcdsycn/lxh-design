package com.lxh.design.builder;

/**
 * @Description 可口可乐
 * @Author lxh
 * @Date 2021/2/16 20:01
 **/
public class Coke extends ColdDrink{
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 35.0F;
    }
}
