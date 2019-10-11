package com.lxh.lamda;
/**
 * Created by lxh on 2018/5/13.
 */

/**
 * @author lxh
 * @Date 2018/5/13
 */
public class ReferenceTest {
    public static int count = 1;
    public static int num = 2;

    public static void test() {
        final int n = 3;
        Calculate calculate = param -> {
            num = 10;//修改静态变量
            count = 3;//修改成员变量
            return n + param;
        };
        int ret = calculate.calculate(10);
        System.out.println(ret);
    }

    public static void main(String[] args) {

        test();
    }

    @FunctionalInterface
    interface Calculate {
        int calculate(int value);
    }
}
