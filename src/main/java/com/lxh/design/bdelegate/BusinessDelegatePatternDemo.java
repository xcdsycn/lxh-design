package com.lxh.design.bdelegate;

/**
 * @Description TODO
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
