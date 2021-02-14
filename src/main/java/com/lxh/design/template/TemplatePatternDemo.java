package com.lxh.design.template;

/**
 * @Description 模板类方法
 * <p>
 *    1. 在模板模式中，抽象类公开了定义的方法/模板来执行它的方法。
 *    2. 它的子类可以根据需要重写方法实现，但调用的方式与抽象类定义的方式相同。
 *    3. 此模式属于行为模式类别。
 *    4. 注意 其与策略模式的区别
 * </p>
 * @Author lxh
 * @Date 2021/2/14 17:45
 **/
public class TemplatePatternDemo {
    public static void main(String[] args) {
        Game game = new Cricket();
        // play是final方法，是具体的业务逻辑，组织好的模板方法
        game.play();

        System.out.println();
        game = new Football();
        game.play();
    }
}
