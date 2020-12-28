package com.lxh.spring.feigntest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value="simple-books-client", url="${book.service.url}")
public interface BooksClient {
    @RequestMapping("/books")
    List<Book> getBooks();
}
