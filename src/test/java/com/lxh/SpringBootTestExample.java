package com.lxh;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;

@SpringBootTest(classes = ApplicationDesign.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootTestExample {

	/**
	 * @LocalServerPort 提供了 @Value("${local.server.port}") 的代替
	 */
	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate restTemplate;

	@BeforeEach
	public void setUp() throws Exception {
		String url = String.format("http://localhost:%d/", port);
		System.out.println(String.format("port is : [%d]", port));
		this.base = new URL(url);
	}

	/**
	 * 向"/test"地址发送请求，并打印返回结果
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {

		ResponseEntity<String> response = this.restTemplate.getForEntity(this.base.toString() + "/test", String.class,
				"");
		System.out.println(String.format("测试结果为：%s", response.getBody()));
	}

}
