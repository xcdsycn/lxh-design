package com.lxh.design.command;
/***
* @Author  lxh
* @Description 作为命令接口 其实现做实际命令的处理
* @Date  2021/2/8 15:43
**/
public interface Command {
    /**
     * 执行命令
     */
    void execute();
}
