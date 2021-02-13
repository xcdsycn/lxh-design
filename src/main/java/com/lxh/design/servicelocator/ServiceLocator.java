package com.lxh.design.servicelocator;

/**
 * @Description 服务定位器
 * <p>
 *     其主要的模式，就是先从缓存取，如果没有，使用上下文类中的工厂方法，创建具体的实现
 *     其查找是根据名字的查找，模拟的是JNDI的方式
 * </p>
 * @Author lxh
 * @Date 2021/2/13 18:08
 **/
public class ServiceLocator {

    private static  Cache cache;
    static {
        cache = new Cache();
    }

    public static Service getService(String jndiName) {
        Service service = cache.getService(jndiName);

        if(service != null) {
            return service;
        }

        InitialContext context = new InitialContext();
        Service service1 = (Service) context.lookup(jndiName);
        cache.addService(service1);
        return service1;
    }
}
