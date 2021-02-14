package com.lxh.design.strategy;

/**
 * @Description 策略接口
 * <p>
 *     1. 在这里定义不同的方法（策略）
 *     2. 由具体类实现各种操作，每一个操作
 * </p>
 * @Author lxh
 * @Date 2021/2/14 17:51
 **/
public interface Strategy {
    int doOperation(int num1, int num2);
}
