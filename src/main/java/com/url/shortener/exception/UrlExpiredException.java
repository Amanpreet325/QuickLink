package com.url.shortener.exception;

public class UrlExpiredException extends RuntimeException {

    public UrlExpiredException() {
        super("URL has expired.");
    }

}
