package com.lxh.design.command;

/**
 * @ClassName Stock
 * @Description 请求对象
 * @Author lxh
 * @Date 2021/2/8 15:48
 * @Version 1.0
 **/
public class Stock {
    private String name = "ABC";

    private int quantity = 10;

    public void buy() {
        System.out.println("Stock [ Name: " + name +", Quantity: " + quantity + " ] bought");
    }

    public void sell() {
        System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] sold");
    }
}
