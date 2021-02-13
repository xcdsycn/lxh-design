package com.lxh.design.interceptor;

/**
 * @Description 截取过滤器模式
 * <p>
 * 当我们想要对应用程序的 请求 或 响应 进行一些 预处理 / 后处理 时，使用截取过滤器设计模式。
 * <p>
 * <p>
 * 过滤器 - 在请求处理程序执行请求 之前 或 之后 执行某些任务的过滤器， 这取决于如何组织过滤器链，把target放在什么位置。
 * 过滤器链 - 携带多个过滤器，并帮助在目标上以定义的顺序执行它们。
 * 目标 - 目标对象是请求处理程序。
 * 过滤器管理器 - 管理过滤器和过滤器链、包括目标业务逻辑，因为过滤器链负责安排target的位置，并执行target的方法。
 * 客户端 - 客户端是向目标（Target）对象发送请求的对象，通过filterManager来发送请求
 * </p>
 * @Author lxh
 * @Date 2021/2/13 21:04
 **/
public class InterceptingFilterDemo {
    public static void main(String[] args) {
        FilterManager filterManager = new FilterManager(new Target());

        filterManager.addFilter(new AuthenticationFilter());
        filterManager.addFilter(new DebugFilter());

        Client client = new Client();
        client.setFilterManager(filterManager);

        client.sendRequest("HOME");
    }
}
