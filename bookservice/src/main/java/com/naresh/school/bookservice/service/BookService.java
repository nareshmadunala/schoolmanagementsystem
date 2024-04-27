package com.naresh.school.bookservice.service;

import com.naresh.school.bookservice.model.Book;

import java.util.List;

public interface BookService {
    Book saveBook(Book book);
    List<Book> getAllBooks();
}
