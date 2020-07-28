package com.kotz.kotz.exception;

public class apiRequestException extends RuntimeException{

    public apiRequestException(String message) {
        super(message);
    }

    public apiRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}