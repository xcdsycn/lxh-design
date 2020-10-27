package com.lxh.generic.inter;

/**
 * 如果能指定类型，就不需要再指定 T 了
 */
public class StringGenerator implements Generator<String>{
    @Override
    public String next() {
        return null;
    }
}
