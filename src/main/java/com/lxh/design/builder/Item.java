package com.lxh.design.builder;

/**
 * @Description TODO
 * @Author lxh
 * @Date 2021/2/16 19:51
 **/
public interface Item {
    String name();

    Packing packing();

    float price();
}
