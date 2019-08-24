package com.lxh.function.templet;

import org.checkerframework.checker.units.qual.A;

/**
 * @author lxh
 */
public class ConstrRefGen {

	static <Ob, X, Y, Z> Ob factory(FuncInt<Ob, X, Y, Z> obj, X p1, Y p2, Z p3) {
		return obj.func(p1, p2, p3);
	}

	public static void main(String[] args) {
		System.out.println();
		FuncInt<Automobile<String, String, Integer>, String, String, Integer> auto_cons = Automobile<String, String, Integer>::new;

		Automobile<String, String, Integer> honda = factory(auto_cons, "Honda", "accord", 2016);
		honda.what();

		Automobile<String, String, Integer> bmw = factory(auto_cons, "bmw", "530i", 2016);
		bmw.what();

	}

}
