package com.hotel.userserviceasync.error;

public class SomethingWentWrongException extends RuntimeException {
    
    public SomethingWentWrongException(String message) {
        super(message);
    }
}
