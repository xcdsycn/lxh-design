package com.lxh.design.strategy;

/**
 * @Description TODO
 * @Author lxh
 * @Date 2021/2/14 17:52
 **/
public class OperationSubstract implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
