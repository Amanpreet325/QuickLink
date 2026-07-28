package com.url.shortener.exception;

public class UrlNotFoundException extends RuntimeException{
    public UrlNotFoundException(){
        super("Url Not Found");
    }
}
