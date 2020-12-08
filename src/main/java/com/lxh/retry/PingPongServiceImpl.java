package com.lxh.retry;

public class PingPongServiceImpl implements PingPongService{
    @Override
    public String call(String ping) throws PingPongServiceException {
        System.out.println("<== pong");
        return "Pong";
    }
}
