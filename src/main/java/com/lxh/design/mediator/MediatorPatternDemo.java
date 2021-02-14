package com.lxh.design.mediator;

/**
 * @Description 协调者模式
 * <p>
 *     1. 中介者模式(Mediator Pattern）用于减少多个对象或类之间的通信复杂性。
 *     2. 此模式提供了一个中介类，它通常处理不同类之间的所有通信，并支持通过松散耦合来维护代码。
 *     3. 中介者模式属于行为模式类别
 * </p>
 * <p>
 *     1. 在这里通过一个聊天室的示例来演示中介者模式的使用，在聊天室中，
 *     多个用户可以向聊天室发送消息，并且聊天室的责任是向所有用户显示消息。
 *     2. 在示例中创建了两个类ChatRoom和User。
 *     3. 用户对象将使用ChatRoom方法来共享他们的消息。
 * </p>
 * @Author lxh
 * @Date 2021/2/14 21:59
 **/
public class MediatorPatternDemo {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John");
        john.sendMessage("hello! Robert!");
    }
}
