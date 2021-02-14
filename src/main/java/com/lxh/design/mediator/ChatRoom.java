package com.lxh.design.mediator;

import java.util.Date;

/**
 * @Description 中介者
 * <p>
 *     中介者，必须使用某个对象，并完成相互之间的通信
 * </p>
 * @Author lxh
 * @Date 2021/2/14 21:56
 **/
public class ChatRoom {

    public static void showMessage(User user, String message) {
        System.out.println(new Date().toInstant() + "[" + user.getName()+"]:"+message);
    }
}
