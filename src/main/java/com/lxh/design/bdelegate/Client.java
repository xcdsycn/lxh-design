package com.lxh.design.bdelegate;

/**
 * @Description 客户端
 * <p>
 *     对于客户端来讲，只与代理服务发生联系
 *     客户端需要指定代理的类型（看代理需要的构建参数），然后调用代理完成任务
 * </p>
 * @Author lxh
 * @Date 2021/2/14 11:31
 **/
public class Client {
    BusinessDelegate businessService;

    public Client(BusinessDelegate businessService) {
        this.businessService = businessService;
    }

    public void doTask() {
        businessService.doTask();
    }
}
