package com.url.shortener.producer;

import com.url.shortener.dto.UrlClickEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UrlEventProducer {

    private final KafkaTemplate<String, UrlClickEvent> kafkaTemplate;

    public void publish(UrlClickEvent event){

        kafkaTemplate.send("url-click-events", event);

        System.out.println("Sent : " + event);
    }

}
