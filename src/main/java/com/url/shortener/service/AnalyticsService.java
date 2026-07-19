package com.url.shortener.service;

import com.url.shortener.repository.ClickAnalyticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnalyticsService {

    private final ClickAnalyticsRepository repository;

    public long getTotalClicks(String shortCode){

        return repository.countByShortCode(shortCode);

    }

    public long getRedisHits(String shortCode){

        return repository.countByShortCodeAndSource(
                shortCode,
                "REDIS"
        );

    }

    public long getDatabaseHits(String shortCode){

        return repository.countByShortCodeAndSource(
                shortCode,
                "DATABASE"
        );

    }

}