package com.lxh.design.visitor;

import java.util.Arrays;

/**
 * @Description 计算机
 * <p>
 *     1. 由不同的部分组成
 *     2. 由计算机访问各组成部分
 *     3. 通过不同的组成部分，在accept方法中，将各部分的visitor方法调用，然后再调用自己的
 *     visit 方法
 * </p>
 * @Author lxh
 * @Date 2021/2/14 17:13
 **/
public class Computer implements ComputerPart{
    ComputerPart[] parts;

    public Computer() {
        parts = new ComputerPart[]{new Mouse(),new Keyboard(),new Monitor()};
    }

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        Arrays.stream(parts).forEach(p->{
            p.accept(computerPartVisitor);
        });
        computerPartVisitor.visit(this);
    }
}
