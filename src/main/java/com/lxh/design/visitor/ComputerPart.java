package com.lxh.design.visitor;

/**
 * @Description 计算机组成部分接口
 * <p>
 *     1. 接收一个visitor 接口
 *     2. 在某一个部分中有业务逻辑，用来表示业务状态
 * </p>
 * @Author lxh
 * @Date 2021/2/14 17:10
 **/
public interface ComputerPart {
    void accept(ComputerPartVisitor computerPartVisitor);
}
