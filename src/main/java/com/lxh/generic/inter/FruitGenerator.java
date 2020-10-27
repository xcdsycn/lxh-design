package com.lxh.generic.inter;

/**
 * 实现时，需要定义实现类的类型，如FruitGenerator<T>
 * @param <T>
 */
public class FruitGenerator<T> implements Generator<T> {
    @Override
    public T next() {
        return null;
    }
}
