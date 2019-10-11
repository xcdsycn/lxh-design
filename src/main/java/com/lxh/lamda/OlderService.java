package com.lxh.lamda;
/**
 * Created by lxh on 2018/5/13.
 */

/**
 * @author lxh
 * @Date 2018/5/13
 */
public class OlderService {
    public static void main(String[] args) {

        final int n = 3;
        Calculate calculate = param -> {
            //n=10; //编译错误
            return n + param;
        };
       int ret =  calculate.calculate(10);
        System.out.println(ret);
    }

    @FunctionalInterface
    interface Calculate {
        int calculate(int value);
    }

}
