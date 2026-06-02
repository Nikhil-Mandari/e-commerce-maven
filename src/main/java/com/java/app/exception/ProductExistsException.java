package com.java.app.exception;

public class ProductExistsException extends Exception{
    public ProductExistsException(String message) {
        super(message);
    }
}