package com.lxh.design.iterator;

/**
 * @Description 迭代项接口，用于描述抽象的项目
 * @Author lxh
 * @Date 2021/2/14 22:06
 **/
public interface Iterator {
    boolean hasNext();
    Object next();
}
