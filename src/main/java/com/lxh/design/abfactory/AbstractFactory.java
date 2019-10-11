package com.lxh.design.abfactory;

import com.lxh.design.abfactory.color.intf.Color;
import com.lxh.design.abfactory.shape.intf.Shape;

/**
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
