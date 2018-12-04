package com.newyeargift.exception;

public class IncorrectOutputException extends Exception {
    private String message;

    public IncorrectOutputException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
