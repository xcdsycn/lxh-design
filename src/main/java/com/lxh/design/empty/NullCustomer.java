package com.lxh.design.empty;

/**
 * @Description 这个是空对象
 * @Author lxh
 * @Date 2021/2/14 20:45
 **/
public class NullCustomer extends AbstractCustomer{
    @Override
    public boolean isNil() {
        return true;
    }

    @Override
    public String getName() {
        return "Not available in customer database";
    }
}
