package com.lxh.design.visitor;

/**
 * @Description 访问者接口
 * <p>
 *     1. 用于根据不同的对象，执行visit操作，定义了所有组成部分的visit方法
 *     2. 这种定义方法的方式是多态
 *     3. 每个具体实现类，以这个接口作媒介，调用多态方法
 *     4. 具体的接口实现类 {@link ComputerPartDisplayVisitor} 实现对具体的方法
 * </p>
 * @Author lxh
 * @Date 2021/2/14 17:11
 **/
public interface ComputerPartVisitor {

    void visit(Computer computer);

    void visit(Mouse mouse);

    void visit(Keyboard keyboard);

    void visit(Monitor monitor);
}
