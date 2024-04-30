package com.naresh.school.dataservice.controller;

import com.naresh.school.dataservice.dto.Book;
import com.naresh.school.dataservice.producer.KafkaAvroProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/data/books")
public class BookController {

    @Autowired
    private KafkaAvroProducer kafkaAvroProducer;

    @PostMapping
    public String send(@RequestBody Book book){

        kafkaAvroProducer.send(book);

        return "Success";
    }
}
