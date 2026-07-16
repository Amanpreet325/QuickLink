package com.url.shortener.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UrlEventProducer {

    private final KafkaTemplate<String,String> kafkaTemplate;

    public void publish(String message){

        kafkaTemplate.send("url-click-events", message);

        System.out.println("Sent : " + message);
    }

}
