package com.lxh.guava.httpclient;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.ExponentialBackOff;
import com.google.common.reflect.TypeToken;
import lombok.SneakyThrows;

import java.lang.reflect.Type;
import java.util.List;

/**
 * HttpRequestFactory this is used to build our requests <br>
 * HttpTransport an abstraction of the low-level HTTP transport layer <br>
 * GenericUrl a class that wraps the Url<br>
 * HttpRequest handles the actual execution of the requesth
 */
public class HttpClientGuavaTest {
	// change to the underlying low-level HTTP transport library of choice: base on HttpURLConnection
	static HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
	// 高级定制类型的，就可以换成下面这个，可以进行低级别的配置，有更多的配置属性
	//	static HttpTransport APACHE_HTTP_TRANSPORT = new ApacheHttpTransport();
	// jackson2
	// The JacksonFactory is the fastest and most popular library for parsing/serialization operations.体积大
	// GSON，体积小
	static JsonFactory JSON_FACTORY = new JacksonFactory();

	@SneakyThrows
	public static void main(String[] args) {
		run();
	}

	@SneakyThrows
	private static void run() {
		HttpRequestFactory requestFactory = HTTP_TRANSPORT.createRequestFactory(
				httpRequest -> {
					httpRequest.setParser(new JsonObjectParser(JSON_FACTORY));
				}
		);
		GitHubUrl url = new GitHubUrl("https://api.github.com/users");
		url.per_page = 10;
		HttpRequest request = requestFactory.buildGetRequest(url);
		// 指定头部信息
		HttpHeaders headers = request.getHeaders();
		headers.setUserAgent("lxh client");
		headers.set("Time-Zone","Asia/Shanghai");
		// 设置重试机制 backoff
		// wait_interval = base * multiplier^n
		// base : initial interval , 第一次重试
		// n 是失败次数
		// multiplier 是一个随意的数字
		ExponentialBackOff backoff = new ExponentialBackOff.Builder()
				.setInitialIntervalMillis(500)
				.setMaxElapsedTimeMillis(900000)
				.setMaxIntervalMillis(6000)
				.setMultiplier(1.5)
				.setRandomizationFactor(0.5)
				.build();
		request.setUnsuccessfulResponseHandler(
				new HttpBackOffUnsuccessfulResponseHandler(backoff));
		// 指定返回类型
		Type type = new TypeToken<List<User>>(){}.getType();
		// 解析返回数据
		List<User> users = (List<User>)request.execute().parseAs(type);
		System.out.println("==> 从Github返回的用户信息:");
		users.forEach(user-> System.out.println(user));

	}

}
