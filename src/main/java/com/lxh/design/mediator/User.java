package com.lxh.design.mediator;

/**
 * @Description 用户类
 * <p>
 *     使用中介者通信，注意this的运用，很奇妙
 * </p>
 * @Author lxh
 * @Date 2021/2/14 21:58
 **/
public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sendMessage(String message) {
        ChatRoom.showMessage(this, message);
    }
}
