package com.mx.mylibrary;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MessageExceptionHandler {

    private int code;
    private String message;
    private Map<String, Object> attributes;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
}
