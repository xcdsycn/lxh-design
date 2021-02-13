package com.lxh.design.fc;

/**
 * @Description 在这里，给具体的执行体分配任务
 * @Author lxh
 * @Date 2021/2/13 22:03
 **/
public class Dispatcher {
    private StudentView studentView;
    private HomeView homeView;

    public Dispatcher() {
        this.studentView = new StudentView();
        this.homeView = new HomeView();
    }

    public void dispatch(String request) {
        if(request.equalsIgnoreCase("home")) {
            homeView.show();
        }else {
            studentView.show();
        }
    }
}
