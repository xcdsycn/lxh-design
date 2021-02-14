package com.lxh.design.chain;

/**
 * @Description 具体的处理类，实现了责任方法
 * @Author lxh
 * @Date 2021/2/14 22:23
 **/
public class ConsoleLogger extends AbstractLogger{

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
