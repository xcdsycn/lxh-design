package com.lxh.spring.feigntest;

import lombok.Data;

@Data
public class Book {
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    private String title;
    private String author;
}
