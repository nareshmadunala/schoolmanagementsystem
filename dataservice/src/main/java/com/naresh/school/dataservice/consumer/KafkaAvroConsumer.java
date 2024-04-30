package com.naresh.school.dataservice.consumer;

import com.naresh.school.dataservice.dto.Book;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaAvroConsumer {

    @KafkaListener(topics = "${topic.name}",containerFactory="BookContainerFactory")
    public void read(ConsumerRecord<String, Book> bookRecord) {
        String key = bookRecord.key();
        Book book = bookRecord.value();
       log.info("Avro message received for key : " + key + " value : " + book.toString());

    }

}
