package com.lxh.classloader.test;
/**
 * Created by lxh on 2018/5/12.
 */

/**
 * @author lxh
 * @Date 2018/5/12
 */
public class Red extends Color {
    public Red() {
        System.out.println("Red is loaded by "+this.getClass().getClassLoader());
    }
}
