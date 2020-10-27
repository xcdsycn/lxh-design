package com.lxh.generic.erase;

import java.util.ArrayList;

/**
 * 类型擦除
 * Java语言泛型在设计的时候为了兼容原来的旧代码，Java的泛型机制使用了“擦除”机制
 */
public class EraseGenerator {

	public static void main(String[] args) {
        Class<?> class1 = new ArrayList<String>().getClass();
        Class<?> class2 = new ArrayList<Integer>().getClass();

        System.out.println(class1);
        System.out.println(class2);

        // 两个类是相等的
        System.out.println("class1 == class2 ?");
        System.out.println(class1.equals(class2));
	}

}
