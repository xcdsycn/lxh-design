package com.lxh.design.empty;

/**
 * @Description 空对象模式
 * @Author lxh
 * <p>
 * 1. 在“空对象”模式中，空对象将替换NULL对象实例的检查。
 * 2. 而不是检查一个空值，Null对象反映一个无关的关系(即什么也不做)。
 * 3. 这种Null对象还可以用于在数据不可用时提供默认行为。
 * 4. 在空对象模式（Null Object模式）中创建一个抽象类，指定要执行的各种操作。
 * 5. 扩展此类的具体类和一个null对象类，不提供此类的任何实现，并且无需检查空值。
 * </p>
 * <p>
 *     1. 基实质是，对于空对象，不返回一个无意义的NULL，而是一个将属性都针对空值进行设置的空对象，这个在做报表系统的时候是有用的
 *     2. 通过空对象，避免判空，少写一些IF ELSE
 * </p>
 * @Date 2021/2/14 20:53
 **/
public class NullPatternDemo {
    public static void main(String[] args) {
        AbstractCustomer customer1 = CustomerFactory.getCustomer("Rob");
        AbstractCustomer customer2 = CustomerFactory.getCustomer("Bob");
        AbstractCustomer customer3 = CustomerFactory.getCustomer("Julie");
        AbstractCustomer customer4 = CustomerFactory.getCustomer("Laura");

        System.out.println("Customers");

        System.out.println(customer1.getName());
        System.out.println(customer2.getName());
        System.out.println(customer3.getName());
        System.out.println(customer4.getName());
    }
}
