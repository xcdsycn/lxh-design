package com.lxh.design.builder;

/**
 * @Description 具体的打包方式：纸包装
 * @Author lxh
 * @Date 2021/2/16 19:52
 **/
public class Wrapper implements Packing {
    @Override
    public String pack() {
        return "Wrapper";
    }
}
