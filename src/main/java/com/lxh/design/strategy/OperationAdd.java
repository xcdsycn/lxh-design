package com.lxh.design.strategy;

/**
 * @Description 实现具体的策略
 * <p>
 *     一种方法代表一种策略，那么可以定义多个方法
 * </p>
 * @Author lxh
 * @Date 2021/2/14 17:51
 **/
public class OperationAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
