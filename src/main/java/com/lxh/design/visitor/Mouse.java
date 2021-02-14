package com.lxh.design.visitor;

/**
 * @Description 具体的接口实现，以 {@link ComputerPartVisitor}作为媒介
 * @Author lxh
 * @Date 2021/2/14 17:13
 **/
public class Mouse implements ComputerPart{
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
