package com.lxh.lamda;

import org.junit.Test;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by lxh on 2018/5/13.
 */
public class ReferenceTestTest {

    /**
     * 返回 布尔值
     */
    @Test
    public void predicateTest() {
        Predicate<String> predicate = (s) -> s.length() > 0;
        boolean test = predicate.test("test");
        System.out.println("字符串长度大于0:" + test);

        test = predicate.test("");
        System.out.println("字符串长度大于0:" + test);

        test = predicate.negate().test("");
        System.out.println("字符串长度小于0:" + test);

        Predicate<Object> pre = Objects::nonNull;
        Object ob = null;
        test = pre.test(ob);
        System.out.println("对象不为空:" + test);
        ob = new Object();
        test = pre.test(ob);
        System.out.println("对象不为空:" + test);
    }

    /**
     * 接收一个参数，返回单一的结果，默认的方法（andThen）可将多个函数串在一起，形成复合Funtion（有输入，有输出）结果
     */
    @Test
    public  void functionTest() {
        Function<String, Integer> toInteger = Integer::valueOf;
        //toInteger的执行结果作为第二个backToString的输入
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        String result = backToString.apply("1234");
        System.out.println(result);

        Function<Integer, Integer> add = (i) -> {
            System.out.println("frist input:" + i);
            return i * 2;
        };
        Function<Integer, Integer> zero = add.andThen((i) -> {
            System.out.println("second input:" + i);
            return i * 0;
        });

        Integer res = zero.apply(8);
        System.out.println(res);
    }

    /**
     * 返回一个给定类型的结果，与Function不同的是，Supplier不需要接受参数(供应者，有输出无输入)
     */
    @Test
    public void supplierTest() {
        Supplier<String> supplier = () -> "special type value";
        String s = supplier.get();
        System.out.println(s);
    }

    /**
     * 代表了在单一的输入参数上需要进行的操作。和Function不同的是，Consumer没有返回值(消费者，有输入，无输出)
     */
    @Test
    public void consumerTest() {
        Consumer<Integer> add5 = (p) -> {
            System.out.println("old value:" + p);
            p = p + 5;
            System.out.println("new value:" + p);
        };
        add5.accept(10);

    }
}
