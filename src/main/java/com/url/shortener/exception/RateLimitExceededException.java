package com.url.shortener.exception;

public class RateLimitExceededException extends RuntimeException{
    public RateLimitExceededException(){
        super("Increased the rate limit");
    }
}
