package com.lxh.design.interpreter;

/**
 * @Description 包含表达式，或者要终结表达式
 * <p>
 *     1. 每种表达式，根据需要，有不同的属性，但是都实现了【解释】方法，用于解释表达式的含义
 *     2. 终结符，代表无法再分解的常量，是构成表达式的最基本的元素
 * </p>
 * @Author lxh
 * @Date 2021/2/14 21:38
 **/
public class TerminalExpression implements Expression{
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if(context.contains(data)) {
            return true;
        }
        return false;
    }
}
