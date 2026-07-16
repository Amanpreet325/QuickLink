package com.url.shortener.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UrlEventConsumer {

    @KafkaListener(topics = "url-click-events",
            groupId = "url-shortener-group")
    public void consume(String message){

        System.out.println("Received : " + message);

    }

}
