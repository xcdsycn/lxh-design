package com.lxh.design.empty;

/**
 * @Description 真实对象
 * <p>
 *     与 {@link NullCustomer} 有不同的属性实现，并不返回null值
 * </p>
 * @Author lxh
 * @Date 2021/2/14 20:32
 **/
public class RealCustomer extends AbstractCustomer{

    public RealCustomer(String name) {
        this.name = name;
    }

    @Override
    public boolean isNil() {
        return false;
    }

    @Override
    public String getName() {
        return name;
    }
}
