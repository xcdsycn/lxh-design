package com.lxh.design.bridge;

/**
 * @Description 抽象类，注意是用抽象来来使用接口，也就是抽象类是算法模板，接口是对象契约
 * <p>
 *     抽象类适合做算法模板，接口适合用来做对象契约，抽象类中的抽象方法，适合做策略模式中的抽象
 *     被保护的BridgeApi-桥接了契约对象 在具体类中，被抽象类中的抽象方法使用【这是重点】
 * </p>
 * @Author lxh
 * @Date 2021/2/9 16:42
 **/
public abstract class AbstractShape {
    protected BridgeApi bridgeApi;

    /**
     * 受保护的方法，注意使用地点
     * @param bridgeApi
     */
    protected AbstractShape(BridgeApi bridgeApi) {
        this.bridgeApi = bridgeApi;
    }

    /**
     * 这个是被调用的算法模板
     */
    public abstract void draw();
}
