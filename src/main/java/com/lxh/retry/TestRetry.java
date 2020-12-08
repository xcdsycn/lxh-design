package com.lxh.retry;

public class TestRetry {
    static int INITIAL_INTERVAL = 100;
    static int MULTIPLIER = 2;
    static int MAX_RETRIES = 3;
    static PingPongService service = new PingPongServiceImpl();
	public static void main(String[] args) {

    }
}
