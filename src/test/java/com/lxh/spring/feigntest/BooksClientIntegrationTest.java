package com.lxh.spring.feigntest;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.lxh.config.WireMockConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WireMockConfig.class })
@EnableFeignClients
public class BooksClientIntegrationTest {
    @Autowired
    private WireMockServer mockBooksService;

    @Autowired
    private BooksClient booksClient;

    @BeforeEach
    void setUp() throws IOException {
        BookMocks.setupMockBooksResponse(mockBooksService);
    }
    @Test
    public void whenGetBooks_thenBooksShouldBeReturned() {
        assertFalse(booksClient.getBooks().isEmpty());
    }

    @Test
    public void whenGetBooks_thenTheCorrectBooksShouldBeReturned() {
        assertTrue(booksClient.getBooks()
                .containsAll(asList(
                        new Book("西游记", "吴承恩"),
                        new Book("三国演义", "罗贯中"))));
    }
}
