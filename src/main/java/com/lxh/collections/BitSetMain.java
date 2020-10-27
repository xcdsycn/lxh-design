package com.lxh.collections;

import java.util.BitSet;

/**
 * 对于bitMap是有局限性的，因为只能设置true false两个值，表达能力有限，但是使用简单
 */
public class BitSetMain {

	public static void main(String[] args) {
        BitSet bitSet =new BitSet(1024);
        bitSet.set(10,20);
        bitSet.stream().forEach(value -> System.out.println(value));
        System.out.println("===> cardinality:" + bitSet.cardinality());

        BitSet bitSet1 = new BitSet(1024);
        bitSet1.set(10,30);
        bitSet.and(bitSet1);
        System.out.println("bitSet values:");
        bitSet.stream().forEach(value -> System.out.println(value));

        System.out.println("bitSet1 values:");
        bitSet1.andNot(bitSet);
        bitSet1.stream().forEach(value -> System.out.println(value));

        System.out.println("bitSet clear bit:13");
        bitSet.clear(13);
        bitSet.stream().forEach(value -> System.out.println(value));

        System.out.println("bitSet 指定位 11 位的补码：");
        bitSet.flip(11);
        bitSet.stream().forEach(value -> System.out.println(value));
        System.out.println("===> 12 位的值：");
        System.out.println(bitSet.get(12));

        System.out.println("bitSet HashCode:" + bitSet.hashCode());

	}
}
