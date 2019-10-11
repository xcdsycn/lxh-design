package com.lxh.classloader;
/**
 * Created by lxh on 2018/5/12.
 */

/**
 * @author lxh
 * @Date 2018/5/12
 */
public class TestMyClassLoader {
    public static void main(String[] args) throws Exception {
        MyClassLoader loader1=new MyClassLoader("loader1");
        loader1.setPath("/Users/lxh/Downloads/test/cl/test1/");

        MyClassLoader loader2=new MyClassLoader(loader1, "loader2");
        loader2.setPath("/Users/lxh/Downloads/test/cl/test2/");

        MyClassLoader loader3=new MyClassLoader(null, "loader3");
        loader3.setPath("/Users/lxh/Downloads/test/cl/test3/");

        loadClassByMyClassLoader("com.lxh.classloader.test.Red",loader2);

        loadClassByMyClassLoader("com.lxh.classloader.test.Red",loader3);
    }

    /**
     * 在这里可以配置好参数
     * 但是有一个主节点来作为调度系统
     * 动态的将类发送到一个主机，可以由操作系统完成
     * 比如调度时间、配置文件
     * 是不是这样就可以作 map reduce 操作了
     * @param name
     * @param loader
     * @throws Exception
     */
    private static void loadClassByMyClassLoader(String name,ClassLoader loader) throws Exception{
        Class<?> c=loader.loadClass(name);
        Object obj=c.newInstance();
    }
}
