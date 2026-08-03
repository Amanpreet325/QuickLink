package com.url.shortener.scheduler;

import com.url.shortener.entity.Url;
import com.url.shortener.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UrlCleanupScheduler {
    private final UrlRepository repository;
    private final RedisTemplate<String, String> redisTemplate;

    @Scheduled(cron = "0 0 2 * * *")
    public void cleanupExpiredUrls() {
        List<Url> expiredUrls =
                repository.findByExpiresAtBefore(LocalDateTime.now());
        repository.deleteAll(expiredUrls);

        for (Url url : expiredUrls) {
            redisTemplate.delete(url.getShortCode());
        }
        System.out.println("Deleted " + expiredUrls.size() + " expired URLs.");
    }
}
