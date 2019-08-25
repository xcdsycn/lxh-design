package com.lxh;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: lxh
 * @Date: 2019/6/14 16:00
 * @Description:
 */
@TestPropertySource(properties = { "app.scheduling.enable=false" })
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationDesign.class)
public class ApplicationTests {

	public ApplicationTests() {
	}

}