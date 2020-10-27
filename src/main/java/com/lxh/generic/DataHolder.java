package com.lxh.generic;

/**
 * 泛型类中有不同类型的泛型方法
 * @param <T>
 */
public class DataHolder<T> {
    T item;

    public void setData(T t) {
        this.item = t;
    }

    public T getData() {
        return this.item;
    }

    public <E> void printInfo(E e) {
        System.out.println(e);
    }

    public static void main(String[] args) {
        System.out.println("===> 在这个类中，类的泛型与方法的泛型不一致，所以不受约束");
        DataHolder<String> dataHolder = new DataHolder<>();
        dataHolder.printInfo(1);
        dataHolder.printInfo("AAAAA");
        dataHolder.printInfo(8.8888f);
	}
}
