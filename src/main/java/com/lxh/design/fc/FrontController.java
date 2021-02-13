package com.lxh.design.fc;

/**
 * @Description 前端控制器
 * <p>
 *     前端控制器，使用Dispatcher分发请求或者做其他的事情，最后一步一定是分发了请求
 *     但是可以有其他的方法
 * </p>
 * @Author lxh
 * @Date 2021/2/13 22:05
 **/
public class FrontController {

    private Dispatcher dispatcher;

    public FrontController() {
        this.dispatcher = new Dispatcher();
    }

    private boolean isAuthenticUser() {
        System.out.println("用户 成功 授权");
        return true;
    }

    private void trackRequest(String request) {
        System.out.println("==> 页面请求：" + request);
    }

    public void dispatchRequest(String request) {
        // log request
        trackRequest(request);

        // authenticate the user
        if(isAuthenticUser()) {
            dispatcher.dispatch(request);
        }
    }
}
