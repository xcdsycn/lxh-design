package com.lxh.design.chain;

/**
 * @Description 具体的处理类
 * @Author lxh
 * @Date 2021/2/14 22:23
 **/
public class FileLogger extends AbstractLogger{

    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File Console::Logger: " + message);
    }
}
