package com.lxh.design.bridge;

/**
 * @Description 具体实现Bridge类
 * @Author lxh
 * @Date 2021/2/9 16:39
 **/
public class GreenCircle implements BridgeApi {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: "
                + radius + ", x: " + x + ", " + y + "]"

        );
    }
}
