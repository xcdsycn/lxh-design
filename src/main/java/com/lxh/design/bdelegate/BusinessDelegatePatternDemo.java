package com.lxh.design.bdelegate;

/**
 * @Description 业务代理模式
 * <p>
 *     业务代理模式用于解耦表示层和业务层。 它基本上用于减少表示层代码中的业务层代码的通信或远程查找功能。
 * </p>
 * <p>
 *     客户端（Client） - 表示层代码可以是JSP，servlet或UI java代码。
 *     业务代理 - 为客户端实体提供对业务服务方法的访问的单个入口点类。
 *     查找服务 - 查找服务对象负责获得相关业务的实施和提供业务的委托对象业务对象的访问。
 *     业务服务 - 业务服务接口。 具体类实现这个业务服务以提供实际的业务实现逻辑
 * </p>
 * @Author lxh
 * @Date 2021/2/14 11:32
 **/
public class BusinessDelegatePatternDemo {
    public static void main(String[] args) {
        BusinessDelegate businessDelegate = new BusinessDelegate();
        businessDelegate.setServiceType("EJB");

        Client client = new Client(businessDelegate);
        client.doTask();

        businessDelegate.setServiceType("JMS");
        client.doTask();
    }
}
