package com.mx.mylibrary;

public class CustomNotFoundException extends Exception {

    public CustomNotFoundException() {
        super();
    }

    public CustomNotFoundException(String message) {
        super(message);
    }
}
