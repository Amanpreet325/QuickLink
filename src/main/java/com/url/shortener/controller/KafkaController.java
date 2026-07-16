package com.url.shortener.controller;
import com.url.shortener.producer.UrlEventProducer;
import lombok.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kafka")
public class KafkaController {

    private final UrlEventProducer producer;

    @PostMapping
    public String send(){

        producer.publish("Hello Kafka");

        return "Sent";

    }

}
