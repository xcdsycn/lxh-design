package com.lxh.design.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 接受命令，执行命令
 * @Author lxh
 * @Date 2021/2/8 15:59
 **/
public class Broker {

    private List<Command> commandList = new ArrayList<>();

    public void acceptCommand(Command command) {
        commandList.add(command);
    }

    public void execCommands() {
        commandList.forEach(o -> {
            o.execute();
        });
        commandList.clear();
    }
}
