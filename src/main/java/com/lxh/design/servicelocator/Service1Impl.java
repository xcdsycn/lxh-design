package com.lxh.design.servicelocator;

/**
 * @Description 具体的服务对象
 * @Link com.lxh.design.servicelocator.Service2Impl的注释
 * @Author lxh
 * @Date 2021/2/13 17:59
 **/
public class Service1Impl implements Service{
    @Override
    public String getName() {
        return "Service1";
    }

    @Override
    public void execute() {
        System.out.println("Execute service 1 ...");
    }
}
