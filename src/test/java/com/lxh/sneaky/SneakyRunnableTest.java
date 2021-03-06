package com.lxh.sneaky;

import com.lxh.ApplicationTests;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SneakyRunnableTest extends ApplicationTests {

	@Test
	public void run() {
		try {
			new SneakyRunnable().run();
		}
		catch (Exception e) {
			assertEquals(InterruptedException.class, e.getClass());
		}
	}

}
