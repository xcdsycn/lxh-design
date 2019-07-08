package com.lxh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lxh
 */
@RestController
@EnableAutoConfiguration
public class ApplicationDesign {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }


    public static void main(String[] args) {
        SpringApplication.run(ApplicationDesign.class, args);
    }
}
