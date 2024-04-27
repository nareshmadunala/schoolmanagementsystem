package com.naresh.school.bookservice.service.impl;

import com.naresh.school.bookservice.model.Book;
import com.naresh.school.bookservice.repository.BookRepository;
import com.naresh.school.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
}
