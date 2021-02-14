package com.lxh.design.strategy;

/**
 * @Description 策略模式
 * <p>
 *    1. 在策略模式中，可以在运行时更改类行为或其算法。
 *    2. 这种类型的设计模式属于行为模式。
 *    3. 在策略模式中，创建表示各种 策略对象 和 其行为根据其策略对象而变化的 上下文对象。
 *    4. 策略对象 更改 上下文对象 的执行算法
 * </p>
 * <p>
 *     1. 策略模式，强调的是策略的可扩充性
 *     2. 模板方法，强调的是如何组织算法，这是两个不同的侧重点
 * </p>
 * @Author lxh
 * @Date 2021/2/14 17:56
 **/
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println(" 10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationSubstract());
        System.out.println(" 10 - 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationMultiply());
        System.out.println(" 10 * 5 = " + context.executeStrategy(10, 5));
    }
}
