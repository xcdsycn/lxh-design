package com.lxh.design.decorator;

/**
 * @Description TODO
 * @Author lxh
 * @Date 2021/2/8 19:25
 **/
public class RedShapeDecorator extends AbstractShapeDecorator {
    /**
     * 抽象类的构造函数必须在子类中调用
     * @param decorateShape
     */
    public RedShapeDecorator(Shape decorateShape) {
        super(decorateShape);
    }

    @Override
    public void draw() {
        super.draw();
        setRedBorder(decorateShape);
    }

    private void setRedBorder(Shape decorateShape) {
        System.out.println("Border color : Red");
    }
}
