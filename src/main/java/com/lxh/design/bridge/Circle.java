package com.lxh.design.bridge;

/**
 * @Description 要实现模板类方法
 * @Author lxh
 * @Date 2021/2/9 16:50
 **/
public class Circle extends AbstractShape{

    private int x;
    private int y;
    private int radius;

    /**
     * 注意方法不是受保护的了
     * @param bridgeApi
     * @param x
     * @param y
     * @param radius
     */
    public Circle(BridgeApi bridgeApi, int x, int y, int radius) {
        super(bridgeApi);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }


    @Override
    public void draw() {
        bridgeApi.drawCircle(radius,x,y);
    }
}
