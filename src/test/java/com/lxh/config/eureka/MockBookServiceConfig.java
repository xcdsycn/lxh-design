package com.lxh.config.eureka;

import com.lxh.spring.feigntest.Book;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@Configuration
@RestController
@ActiveProfiles("eureka-test")
public class MockBookServiceConfig {
    @RequestMapping("/books")
    public List getBooks() {
        return Collections.singletonList(new Book("Hitchhiker's Guide to the Galaxy", "Douglas Adams"));
    }
}
