package com.lxh.design.interpreter;

/**
 * @Description 解释器模式
 * <p>
 *
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
