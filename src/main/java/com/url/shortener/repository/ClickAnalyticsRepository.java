package com.url.shortener.repository;

import com.url.shortener.entity.ClickAnalytics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClickAnalyticsRepository
        extends JpaRepository<ClickAnalytics, Long> {

    List<ClickAnalytics> findByShortCode(String shortCode);

    long countByShortCode(String shortCode);

    long countByShortCodeAndSource(
            String shortCode,
            String source
    );
}