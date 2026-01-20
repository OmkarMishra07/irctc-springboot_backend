package com.irctc.irctc_backend.exception;

public class InvalidUserException extends RuntimeException {
    public InvalidUserException(String message){
        super(message);
    }
}
