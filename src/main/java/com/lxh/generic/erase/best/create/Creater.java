package com.lxh.generic.erase.best.create;

/**
 * 泛型工厂
 * @param <T>
 */
public class Creater<T> {
    T instance;

    public <F extends Factory<T>> T newInstance(F f) {
        instance = f.create();
        return instance;
    }
}
