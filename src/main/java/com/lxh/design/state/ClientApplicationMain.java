package com.lxh.design.state;

public class ClientApplicationMain {
    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new PublishState());
        //publish --> not pay
        context.acceptOrderEvent(context);
        //not pay --> paid
        context.payOrderEvent(context);
        // 失败
//        context.checkFailEvent(context);
    }
}
