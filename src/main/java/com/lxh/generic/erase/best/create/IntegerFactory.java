package com.lxh.generic.erase.best.create;

/**
 * 泛型工厂实现类
 */
public class IntegerFactory implements Factory<Integer>{
    @Override
    public Integer create() {
        Integer integer = new Integer(9);
        return integer;
    }
}
