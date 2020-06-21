package com.lxh.sneaky;

import lombok.SneakyThrows;

/**
 * sneaky throws 可以不写try catch 将异常直接向上抛出， 也可以将 Runtime Exception 转成 checked Exception
 *
 * @author lxh
 */
public class SneakyRunnable implements Runnable {

	@Override
	@SneakyThrows(Exception.class)
	public void run() {
		throw new InterruptedException("this is a exception");
	}

}
