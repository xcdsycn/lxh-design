package com.lxh.design.abfactory;

import com.lxh.design.abfactory.color.Blue;
import com.lxh.design.abfactory.color.Green;
import com.lxh.design.abfactory.color.Red;
import com.lxh.design.abfactory.color.intf.Color;
import com.lxh.design.abfactory.shape.Circle;
import com.lxh.design.abfactory.shape.Rectangle;
import com.lxh.design.abfactory.shape.Square;
import com.lxh.design.abfactory.shape.intf.Shape;

/**
 * @author lxh
 */
public class ColorFactory extends AbstractFactory {

	@Override
	Color getColor(String color) {
		if(color == null){
			return null;
		}

		if(color.equalsIgnoreCase("RED")){
			return new Red();

		}else if(color.equalsIgnoreCase("GREEN")){
			return new Green();

		}else if(color.equalsIgnoreCase("BLUE")){
			return new Blue();
		}

		return null;



	}

	@Override
	Shape getShape(String shapeType) {
	 return null;
	}

}
