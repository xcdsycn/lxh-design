package com.lxh.design.interpreter;

/**
 * @Description 表达式接口，定义了解释的方法
 * @Author lxh
 * @Date 2021/2/14 21:37
 **/
public interface Expression {
    boolean interpret(String context);
}
