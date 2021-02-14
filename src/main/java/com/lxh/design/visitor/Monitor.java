package com.lxh.design.visitor;

/**
 * @Description 具体的实现
 * <p>
 *     这里奇怪是的Computer类也实现了 {@link ComputerPart} 接口
 *     要注意的，总的组成部分 {@link Computer}的accept方法与各组成部分的方法不同
 * </p>
 * @Author lxh
 * @Date 2021/2/14 17:12
 **/
public class Monitor implements ComputerPart{
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
