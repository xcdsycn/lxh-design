package com.lxh;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

/**
 * @Auther: lxh
 * @Date: 2019/6/14 16:00
 * @Description:
 */
@TestPropertySource(properties = { "app.scheduling.enable=false" })
@SpringBootTest(classes = ApplicationDesign.class)
public class ApplicationTests {

	public ApplicationTests() {
	}

}