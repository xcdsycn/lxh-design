package com.lxh.generic.ext;

/**
 * 上界通配，下界，无限匹配
 */
public class Ext {
    class Fruit{}
    class Apple extends Fruit{}

    class Plate<T> {
        T item;
        public Plate(T t) {
            item = t;
        }

        public void set(T t) {
            item = t;
        }

        public T get() {
            return item ;
        }
    }

    public static void main(String[] args) {

	}

	public void test() {
        // 上界通配（extends），只能get，不能Set，适合读，
        Plate<? extends Fruit> p = new Plate<Apple>( new Apple());
        // 下界通配 ? super T，set可以，get出来的对象是Object，适合插入
        // 无限通配 ？ 只能用来只读，用业标识参数，如：List<?>一般只用于读取情景中，不能add增加元素，除非是null。


    }
}
