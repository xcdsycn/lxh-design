package com.lxh.generic.erase.best;

/**
 * 解决泛型的类型信息由于擦除无法进行类型判断的问题 <br>
 * 通过记录类型参数的Class对象，然后通过这个Class对象进行类型判断。
 * @param <T>
 */
public class GenericType<T> {
    Class<?> classType;

    public GenericType(Class<?> type) {
        classType = type;
    }

    public boolean isInstance(Object object) {
        return classType.isInstance(object);
    }

    public static void main(String[] args) {
        GenericType<String> genericType = new GenericType<>(String.class);
        genericType.test();

	}
	public void test() {
        GenericType<A> genericType = new GenericType<>(A.class);
        System.out.println("-----------------------------------");
        System.out.println(genericType.isInstance(new A()));
        System.out.println(genericType.isInstance(new B()));
    }
	class A {}
	class B {}
}
