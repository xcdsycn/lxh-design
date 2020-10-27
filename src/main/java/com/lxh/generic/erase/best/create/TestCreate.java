package com.lxh.generic.erase.best.create;

/**
 * 泛型代码中不能new T()的原因有两个，一是因为擦除，不能确定类型；而是无法确定T是否包含无参构造函数。
 * 为了避免这两个问题，我们使用显式的工厂模式：
 */
public class TestCreate {

	public static void main(String[] args) {
        Creater<Integer> creater = new Creater<>();
        System.out.println(creater.newInstance(new IntegerFactory()));
	}
}
