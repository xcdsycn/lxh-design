package com.lxh.design.strategy;

/**
 * @Description 策略执行的上下文
 * @Author lxh
 * @Date 2021/2/14 17:54
 **/
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 执行策略
     * @param num1
     * @param mum2
     * @return
     */
    public int executeStrategy(int num1, int mum2) {
        return strategy.doOperation(num1, mum2);
    }
}
