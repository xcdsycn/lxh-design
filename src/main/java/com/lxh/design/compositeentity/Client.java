package com.lxh.design.compositeentity;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author lxh
 * @Date 2021/2/13 22:41
 **/
public class Client {
    private CoarseEntity coarseEntity = new CoarseEntity();

    public void printData() {
        Arrays.stream(coarseEntity.getData()).forEach(System.out::println);
    }

    public void setData(String data1, String data2) {
        coarseEntity.setData(data1, data2);
    }
}
