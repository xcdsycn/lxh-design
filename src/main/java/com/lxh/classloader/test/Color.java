package com.lxh.classloader.test;
/**
 * Created by lxh on 2018/5/12.
 */

/**
 * @author lxh
 * @Date 2018/5/12
 */
public class Color {

	public Color() {
		System.out.println("Color is loaded by " + this.getClass().getClassLoader());
	}

}
