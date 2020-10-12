package com.lxh.collections;

import java.util.BitSet;

public class BitSetMain {

	public static void main(String[] args) {
        BitSet bitSet =new BitSet(1024);
        bitSet.set(10,20);
        bitSet.stream().forEach(value -> System.out.println(value));
	}
}
