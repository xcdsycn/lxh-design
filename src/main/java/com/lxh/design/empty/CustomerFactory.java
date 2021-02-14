package com.lxh.design.empty;

/**
 * @Description 工厂类，用于返回 {@link RealCustomer} 或 {@link NullCustomer}
 * @Author lxh
 * @Date 2021/2/14 20:46
 **/
public class CustomerFactory {

    public static final String[] names = {"Rob","Joe","Julie"};

    public static AbstractCustomer getCustomer(String name) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(name)){
                return new RealCustomer(name);
            }
        }
        return new NullCustomer();
    }
}
