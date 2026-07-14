package com.url.shortener.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UrlResponse {

    private String shortUrl;
}
