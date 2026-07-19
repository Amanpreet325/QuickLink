package com.url.shortener.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "url_clicks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClickAnalytics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shortCode;

    @Column(columnDefinition = "TEXT")
    private String originalUrl;

    private LocalDateTime clickedAt;

    private String source;
}