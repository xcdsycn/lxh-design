package com.lxh.design.builder;

/**
 * @Description 具体的汉堡
 * @Author lxh
 * @Date 2021/2/16 20:01
 **/
public class ChickenBurger extends Burger{
    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 50.5F;
    }
}
