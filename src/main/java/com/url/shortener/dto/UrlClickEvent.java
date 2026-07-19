package com.url.shortener.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UrlClickEvent {

    private String shortCode;

    private String originalUrl;

    private LocalDateTime clickedAt;
    private String source;

}