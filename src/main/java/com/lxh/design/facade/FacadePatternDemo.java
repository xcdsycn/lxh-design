package com.lxh.design.facade;

/**
 * @Description 使用Facade来绘制各种形状
 * @Author lxh
 * @Date 2021/2/8 18:58
 **/
public class FacadePatternDemo {

	public static void main(String[] args) {
        ShapeFacade facade = new ShapeFacade();

        facade.drawCircle();
        facade.drawRectangle();
        facade.drawSquare();
	}
}
