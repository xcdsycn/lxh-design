package com.lxh.design.builder;

/**
 * @Description 具体的打包方式，瓶装
 * @Author lxh
 * @Date 2021/2/16 19:53
 **/
public class Bottle implements Packing{
    @Override
    public String pack() {
        return "Bottle";
    }
}
