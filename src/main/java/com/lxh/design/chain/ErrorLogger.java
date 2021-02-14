package com.lxh.design.chain;

/**
 * @Description 具备的处理类
 * @Author lxh
 * @Date 2021/2/14 22:23
 **/
public class ErrorLogger extends AbstractLogger{

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
