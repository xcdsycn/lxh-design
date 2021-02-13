package com.lxh.design.fc;

/**
 * @Description 前端控制器模式
 * <p>
 *    前端控制器设计模式用于提供集中式请求处理机制，以便所有请求将由单个处理程序处理。
 *    此处理程序可以执行请求的身份验证/授权/记录或跟踪，然后将请求传递到相应的处理程序。
 * </p>
 * <p>
 *     前端控制器 - 用于处理应用程序（基于Web或基于桌面）的各种请求的单个处理程序。
 *     分发器 - 前端控制器可以使用可以将请求分派到相应的特定处理器的分派器对象。
 *     视图 - 视图是进行请求的对象。
 * </p>
 * <p>
 *     像这这种设计，在一般的编程设计中，会以单个类来实现
 *     采用设计模式的好处，是可以扩展， 缺点也明显，类多，如果对其不熟悉不会把握其意图，类多了，跳几下，人就找不到北了
 *     不采用设计模式的好处，是简单，缺点是可扩展性不强
 *     针对以上的总结：如果只是实现小的方法，不需要用设计模式，就是说不要用大炮打蚊子
 *     如果是要设计一个关键部件，一定要考虑如何合理的用设计模式，这样才能在以后进行优化，扩展组件的能力
 * </p>
 * @Author lxh
 * @Date 2021/2/13 22:00
 **/
public class FrontControllerDemo {
    public static void main(String[] args) {
        FrontController frontController = new FrontController();

        frontController.dispatchRequest("HOME");
        frontController.dispatchRequest("STUDENT");
    }
}
