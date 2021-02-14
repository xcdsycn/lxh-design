package com.lxh.design.interpreter;

/**
 * @Description 解释器模式
 * <p>
 * 1. 解释器模式提供了一种评估计算语言语法或表达式的方法。
 * 2. 这种类型的模式属于行为模式。
 * 3. 这种模式涉及实现一个表达式接口，它告诉解释一个指定的上下文。
 * 4. 此模式用于SQL解析，符号处理引擎等。
 * </p>
 * @Author lxh
 * @Date 2021/2/14 21:41
 **/
public class InterpreterDemo {

    public static Expression getMaleExpression() {
        // Rule: Robert and John are male
        Expression robert = new TerminalExpression("Robert");
        Expression john = new TerminalExpression("John");
        return new OrExpression(robert, john);
    }

    public static Expression getMarriedWomenExpression() {
        // Rule: Julie is a married women
        Expression robert = new TerminalExpression("Julie");
        Expression john = new TerminalExpression("Married");
        return new AndExpression(robert, john);
    }

    public static void main(String[] args) {
        Expression isMale = getMaleExpression();
        Expression isMarriedWoman = getMarriedWomenExpression();

        System.out.println("John is male? " + isMale.interpret("John"));
        System.out.println("Julie is a married women? " + isMarriedWoman.interpret("Married Julie"));

    }
}
