package com.lxh.design.builder;

/**
 * @Description 蔬菜汉堡
 * @Author lxh
 * @Date 2021/2/16 20:00
 **/
public class VegBurger extends Burger{
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0F;
    }
}
