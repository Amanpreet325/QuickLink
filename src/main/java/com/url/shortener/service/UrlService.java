package com.url.shortener.service;

import com.url.shortener.entity.Url;
import com.url.shortener.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository repository;
    private final StringRedisTemplate redisTemplate;

    public String createShortUrl(String originalUrl) {

        String shortCode =
                UUID.randomUUID()
                        .toString()
                        .substring(0,6);

        Url url = Url.builder()
                .shortCode(shortCode)
                .originalUrl(originalUrl)
                .createdAt(LocalDateTime.now())
                .build();

        repository.save(url);

        return shortCode;
    }

    public String getOriginalUrl(String code) {
        String url =  redisTemplate.opsForValue().get(code);

        if(url != null){
            return url;
        }

        Url entity = repository.findByShortCode(code)
                .orElseThrow();

        redisTemplate.opsForValue()
                .set(code, entity.getOriginalUrl(), Duration.ofHours(24));

        return entity.getOriginalUrl();
    }
}