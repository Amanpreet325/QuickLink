package com.url.shortener.controller;

import com.url.shortener.service.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/analytics")
public class AnalyticsController {

    private final AnalyticsService service;

    @GetMapping("/{code}")
    public Map<String,Object> analytics(
            @PathVariable String code){

        Map<String,Object> response =
                new HashMap<>();

        response.put("shortCode", code);

        response.put(
                "totalClicks",
                service.getTotalClicks(code));

        response.put(
                "redisHits",
                service.getRedisHits(code));

        response.put(
                "databaseHits",
                service.getDatabaseHits(code));

        return response;

    }
}