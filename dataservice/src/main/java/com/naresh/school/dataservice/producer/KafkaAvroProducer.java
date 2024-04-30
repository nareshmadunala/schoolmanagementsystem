package com.naresh.school.dataservice.producer;

import com.naresh.school.dataservice.dto.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;


@Service
@Slf4j
public class KafkaAvroProducer {

    @Value("${topic.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, Book> kafkaTemplate;


    public void send(Book book){

       CompletableFuture<SendResult<String, Book>> completableFuture = kafkaTemplate.send(topicName, UUID.randomUUID().toString(),book);

        completableFuture.whenComplete((result, ex)->{
            if(ex == null){
                log.info(" Message Sent = [" + book +
                "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }else{
                log.info(" Unable to send message = [ " + book +
                        " ] due to : "+ ex.getMessage());
            }

        });
    }

}
