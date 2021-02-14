package com.lxh.design.bdelegate;

/**
 * @Description 查找服务，这里是用工厂方法来做的
 * @Author lxh
 * @Date 2021/2/14 11:28
 **/
public class BusinessLookUp {

    public BusinessService getBusinessService(String serviceType) {
        if (serviceType.equalsIgnoreCase("EJB")) {
            return new EJBService();
        }else {
            return new JMSService();
        }
    }
}
