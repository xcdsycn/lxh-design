package com.lxh.design.builder;

/**
 * @Description 百事可乐
 * @Author lxh
 * @Date 2021/2/16 20:02
 **/
public class Pesi extends ColdDrink{
    @Override
    public String name() {
        return "Pesi";
    }

    @Override
    public float price() {
        return 35.0F;
    }
}
