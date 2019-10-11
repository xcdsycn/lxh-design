package com.lxh.design.abfactory.color;

import com.lxh.design.abfactory.color.intf.Color;

/**
 * @author lxh
 */
public class Blue implements Color {

	@Override
	public void fill() {
		System.out.println("Inside Blue::fill() method.");
	}

}
