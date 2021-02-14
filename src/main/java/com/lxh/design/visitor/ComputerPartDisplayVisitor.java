package com.lxh.design.visitor;

/**
 * @Description 定义了一个 显示 {@link sun.reflect.generics.visitor.Visitor}
 * <p>
 *     实现各部分的访问方法
 * </p>
 * @Author lxh
 * @Date 2021/2/14 17:17
 **/
public class ComputerPartDisplayVisitor implements ComputerPartVisitor{
    @Override
    public void visit(Computer computer) {
        System.out.println("显示 计算机，这个是在计算机调用完其他的方法后，最后出现的");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("显示 鼠标");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("显示 键盘");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("显示 显示器");
    }
}
