package com.url.shortener.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data

@Builder
public class UrlResponse {

    private String shortCode;

    private String shortUrl;
}
