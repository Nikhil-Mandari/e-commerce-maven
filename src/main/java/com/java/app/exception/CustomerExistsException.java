package com.java.app.exception;

public class CustomerExistsException extends Exception {
    public CustomerExistsException(String message) {
        super(message);
    }
}