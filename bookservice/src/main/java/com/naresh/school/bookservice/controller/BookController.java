package com.naresh.school.bookservice.controller;

import com.naresh.school.bookservice.model.Book;
import com.naresh.school.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService bookServiceImpl;

    @GetMapping
    public List<Book> getAllBooks(){
        return bookServiceImpl.getAllBooks();
    }

    @PostMapping
    public Book saveBook(@RequestBody Book book){
        return bookServiceImpl.saveBook(book);
    }

}
