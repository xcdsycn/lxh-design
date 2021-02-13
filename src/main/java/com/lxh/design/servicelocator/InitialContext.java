package com.lxh.design.servicelocator;

/**
 * @Description 为JNDI查找，创建的类
 * <p>
 *     相当于工厂类，用来创建具体的实现
 * </p>
 * @Author lxh
 * @Date 2021/2/13 18:00
 **/
public class InitialContext {
    public Object lookup(String jndiName) {
        if(jndiName.equalsIgnoreCase("service1")){
            System.out.println("Looking up and creating a new Service1 object");
            return new Service1Impl();
        }else if(jndiName.equalsIgnoreCase("service2")) {
            System.out.println("Looking up and creating a new Service2 object");
            return new Service2Impl();
        }
        return null;
    }
}
