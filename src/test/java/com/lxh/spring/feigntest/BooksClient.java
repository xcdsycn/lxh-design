package com.lxh.spring.feigntest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
/**
 * 这是Ribbon服务，如果不用Ribbon注需要指定URL，其依赖于ribbon插件
 */
@FeignClient("book-service")
//@FeignClient(value="simple-books-client", url="${book.service.url}")
public interface BooksClient {
    @RequestMapping("/books")
    List<Book> getBooks();
}
