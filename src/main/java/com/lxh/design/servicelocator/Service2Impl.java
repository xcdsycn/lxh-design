package com.lxh.design.servicelocator;

/**
 * @Description 具体的服务对象
 * <p>
 *     这里的名字与输入的参数相关，因为没有set方法，所以会出问题，用抽象类比较好，因为有属性
 * </p>
 * @Author lxh
 * @Date 2021/2/13 17:59
 **/
public class Service2Impl implements Service{
    @Override
    public String getName() {
        return "Service2";
    }

    @Override
    public void execute() {
        System.out.println("Execute service 2 ...");
    }
}
