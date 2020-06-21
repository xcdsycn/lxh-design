package com.lxh.function.templet;

/**
 * 这个是定义用来使用函数的 就是说，这个用来定义函数作为参数传递时的原型，使用的时候，需要是这种类型的函数 就可以用来调用这种类型的函数了
 *
 * @author lxh
 */
public interface FuncInt<Ob, X, Y, Z> {

	/**
	 * 根据函数签名，匹配函数，然后调用相应的函数
	 * @param make
	 * @param model
	 * @param year
	 * @return
	 */
	Ob func(X make, Y model, Z year);

}
