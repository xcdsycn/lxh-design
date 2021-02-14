package com.lxh.design.iterator;

/**
 * @Description 迭代器模式
 * <p>
 * 1. 迭代器模式是Java和.Net编程环境中非常常用的设计模式。
 * 2. 此模式用于以顺序方式访问集合对象的元素，而不需要知道其底层表示。
 * 3. 迭代器模式属于行为模式类别。
 * </p>
 * @Author lxh
 * @Date 2021/2/14 22:10
 **/
public class IteratorPatternDemo {
    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();

        for (Iterator iterator = nameRepository.getIterator(); iterator.hasNext(); ) {
            String name = (String) iterator.next();
            System.out.println("Name:" + name);
        }
    }
}
