package com.lxh.function.notemplet;

/**
 * @author lxh
 */
public class ConstRef {

	static void createInstance() {

	}

	public static void main(String[] args) {
		System.out.println();
		FunInt auto = Automobile::new;

		Automobile honda = auto.auto("honda", "Accord", (short) 2006);
		honda.what();

		Automobile bmw = auto.auto("bmw", "530i", (short) 2006);
		bmw.what();
	}

}
