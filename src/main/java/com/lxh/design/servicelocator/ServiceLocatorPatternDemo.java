package com.lxh.design.servicelocator;

/**
 * @Description 服务定位主类
 * <p>
 *     通过ServiceLocator查找服务
 *     通过缓存提升查找性能，不需要每次创建
 * </p>
 * @Author lxh
 * @Date 2021/2/13 18:10
 **/
public class ServiceLocatorPatternDemo {
    public static void main(String[] args) {
        Service service = ServiceLocator.getService("service1");
        service.execute();

        service = ServiceLocator.getService("Service2");
        service.execute();

        service = ServiceLocator.getService("service1");
        service.execute();

        service = ServiceLocator.getService("service2");
        service.execute();

    }
}
