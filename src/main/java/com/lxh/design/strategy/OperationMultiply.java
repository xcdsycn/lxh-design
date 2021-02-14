package com.lxh.design.strategy;

/**
 * @Description 实现具体的策略
 * @Author lxh
 * @Date 2021/2/14 17:54
 **/
public class OperationMultiply implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
