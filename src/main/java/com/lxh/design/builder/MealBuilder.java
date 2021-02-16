package com.lxh.design.builder;

/**
 * @Description 建造者（Builder）
 * <p>
 *     1. 这个是用来表示如何创建对象的一个类
 *     2. 重点是，如何分割类，创建一组对象
 *     3. Meal是一组类（Item）的列表
 * </p>
 * @Author lxh
 * @Date 2021/2/16 20:07
 **/
public class MealBuilder {
    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNoVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pesi());
        return meal;
    }
}
