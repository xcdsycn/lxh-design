package com.lxh.stream;

/**
 * Created by lxh on 2018/5/13.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author lxh
 * @Date 2018/5/13
 */
public class Exmaple {

	private static List<String> lists;

	static {
		lists = new ArrayList<String>();
		lists.add("a1");
		lists.add("a2");
		lists.add("b1");
		lists.add("b2");
		lists.add("b3");
		lists.add("o1");
	}

	public static void streamFilterTest() {
		lists.stream().filter((s -> s.startsWith("a"))).forEach(System.out::println);

		// 等价于以上操作
		Predicate<String> predicate = (s) -> s.startsWith("a");
		lists.stream().filter(predicate).forEach(System.out::println);

		// 连续过滤
		Predicate<String> predicate1 = (s -> s.endsWith("1"));
		lists.stream().filter(predicate).filter(predicate1).forEach(System.out::println);
	}

	public static void main(String[] args) {
		streamFilterTest();
	}

}
