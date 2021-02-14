package com.lxh.design.interpreter;

/**
 * @Description OR表达式
 * <p>
 *     需要两个表达式，来表达OR关系
 * </p>
 * @Author lxh
 * @Date 2021/2/14 21:39
 **/
public class OrExpression implements Expression {
    private Expression expr1 = null;
    private Expression expr2 = null;

    public OrExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) || expr2.interpret(context);
    }
}
