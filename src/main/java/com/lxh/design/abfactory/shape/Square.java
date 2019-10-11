package com.lxh.design.abfactory.shape;

import com.lxh.design.abfactory.shape.intf.Shape;

/**
 * @author lxh
 */
public class Square implements Shape {

	@Override
	public void draw() {
		System.out.println("Inside Square::draw() method.");
	}

}
