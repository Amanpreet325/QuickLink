package com.url.shortener.exception;

public class ShortCodeAlreadyExistsException extends RuntimeException{
    public ShortCodeAlreadyExistsException() {
        super("ShortCode Already Exists.");
    }
}
