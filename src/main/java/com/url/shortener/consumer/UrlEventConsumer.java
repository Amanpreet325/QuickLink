package com.url.shortener.consumer;

import com.url.shortener.dto.UrlClickEvent;
import com.url.shortener.entity.ClickAnalytics;
import com.url.shortener.repository.ClickAnalyticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UrlEventConsumer {
    private final ClickAnalyticsRepository repository;

    @KafkaListener(topics = "url-click-events",
            groupId = "url-shortener-group")
    public void consume(UrlClickEvent event){
        ClickAnalytics analytics =
                ClickAnalytics.builder()
                        .shortCode(event.getShortCode())
                        .originalUrl(event.getOriginalUrl())
                        .clickedAt(event.getClickedAt())
                        .source(event.getSource())
                        .build();

        repository.save(analytics);

        System.out.println("Saved Analytics : " + analytics);

    }

}
