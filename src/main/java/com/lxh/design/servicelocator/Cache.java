package com.lxh.design.servicelocator;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description 避免每次查找，建立的缓存
 * @Author lxh
 * @Date 2021/2/13 18:03
 **/
public class Cache {
    // 使用Set，避免重复的判断
    private Set<Service> services;

    public Cache() {
        services = new HashSet<>();
    }

    public Service getService(String serviceName) {
        for(Service service : services) {
            if(service.getName().equalsIgnoreCase(serviceName)) {
                System.out.println(" 返回 缓存 的 服务 ：" + serviceName + " 对象");
                return service;
            }
        }
        return null;
    }


    public void addService(Service newService) {
        services.add(newService);
    }

}
