package com.lxh.design.abfactory;

import com.lxh.design.abfactory.color.intf.Color;
import com.lxh.design.abfactory.shape.intf.Shape;

/**
 *
 * 抽象工厂模式是一个超级工厂，用来创建其他工厂。 这个工厂也被称为工厂的工厂。
 * 这种类型的设计模式属于创建模式，因为此模式提供了创建对象的最佳方法之一。
 * 在抽象工厂模式中，接口负责创建相关对象的工厂，而不明确指定它们的类。
 * 每个生成的工厂可以按照工厂模式提供对象。
 *
 * @author lxh
 */
public abstract class AbstractFactory {

	/**
	 * get color
	 * @param color
	 * @return
	 */
	abstract Color getColor(String color);

	/**
	 * get shape
	 * @param shapeType
	 * @return
	 */
	abstract Shape getShape(String shapeType);

}
