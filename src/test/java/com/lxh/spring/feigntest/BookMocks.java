package com.lxh.spring.feigntest;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.net.URL;

import static java.nio.charset.Charset.defaultCharset;
import static org.springframework.util.StreamUtils.copyToString;

public class BookMocks {

    public static void setupMockBooksResponse(WireMockServer mockService) throws IOException {
        URL resource = BookMocks.class.getClassLoader().getResource("payload");
        System.out.println("==> url:"+ resource);
        mockService.stubFor(WireMock.get(WireMock.urlEqualTo("/books"))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(
                                copyToString(
                                        BookMocks.class.getClassLoader().getResourceAsStream("payload/get-books-response.json"),
                                        defaultCharset()))));
    }
}
