package com.lxh.retry;

public interface PingPongService {
    /**
     * The client application must retry if the PingPongService returns a PingPongServiceException.
     * @param ping
     * @return
     * @throws PingPongServiceException
     */
    String call(String ping) throws PingPongServiceException;
}
