package com.url.shortener.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShortenRequest {

    private String originalUrl;

    @Size(min = 3, max = 20,
            message = "Custom code must be between 3 and 20 characters.")

    @Pattern(
            regexp = "^[a-zA-Z0-9_-]*$",
            message = "Custom code can only contain letters, numbers, '-' and '_'."
    )
    private String customCode;

    private LocalDateTime expiresAt;
}