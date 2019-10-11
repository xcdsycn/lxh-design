package com.lxh.design.abfactory.shape;

import com.lxh.design.abfactory.shape.intf.Shape;

/**
 * @author lxh
 */
public class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Inside Circle::draw() method.");
	}

}
