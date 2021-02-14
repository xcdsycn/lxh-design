package com.lxh.design.empty;

/**
 * @Description 抽象顾客
 * <p>
 *     注意这里的保护方法与抽象方法
 * </p>
 * @Author lxh
 * @Date 2021/2/14 18:09
 **/
public abstract class AbstractCustomer {
    protected String name;
    public abstract boolean isNil();
    public abstract String getName();
}
