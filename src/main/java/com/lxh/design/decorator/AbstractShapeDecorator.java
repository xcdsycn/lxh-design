package com.lxh.design.decorator;

/**
 * @Description 装饰器模式允许用户向现有对象添加新功能而不改变其结构。 <Br>
 * 这种类型的设计模式属于结构模式，因为此模式充当现有类的包装器。<br>
 * 此模式创建一个装饰器类，它包装原始类并提供附加功能，保持类方法签名完整。<br>
 * 我们通过以下示例展示装饰器模式的使用，其中我们将用一些颜色装饰形状而不改变形状类
 *
 * 《这个是抽象类》， 不能用的，所以要有一个具体类，抽象类隐藏了具体的实现，不能消费者看到
 *
 * 《与门面模式的区别》：是装饰器可以给原来的抽象类，增加功能，而门面模式，只是各种功能的组合或代理
 *
 * 《装饰器 可以理解为》 给某个接口扩充功能，那么实现这些接口的所有类，都可以被装饰器装饰，从而达到对一类接口及实现的功能扩充
 * @Author lxh
 * @Date 2021/2/8 19:14
 **/
public abstract class AbstractShapeDecorator implements Shape {

	protected Shape decorateShape;

	public AbstractShapeDecorator(Shape decorateShape) {
		this.decorateShape = decorateShape;
	}

	@Override
	public void draw() {
		decorateShape.draw();
	}

}
