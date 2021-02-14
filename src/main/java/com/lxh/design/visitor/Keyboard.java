package com.lxh.design.visitor;

/**
 * @Description
 * @Author lxh
 * @Date 2021/2/14 17:11
 **/
public class Keyboard implements ComputerPart{
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
