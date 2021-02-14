package com.lxh.design.bdelegate;

/**
 * @Description 业务代理类
 * <p>
 *     主要的业务逻辑都在这里了
 *     1. 查找服务
 *     2. 业务服务
 *     3. 服务类型
 *     4. ==> 设置业务类型，调用查找服务找到服务，调用服务完成任务
 * </p>
 * @Author lxh
 * @Date 2021/2/14 11:29
 **/
public class BusinessDelegate {
    private BusinessLookUp lookUp = new BusinessLookUp();

    private BusinessService businessService;

    private String serviceType;

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void doTask() {
        businessService = lookUp.getBusinessService(serviceType);
        businessService.doProcessing();
    }
}
