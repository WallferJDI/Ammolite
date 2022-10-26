package com.knits.ammolite.exceptions;

public class LocationException extends AppException{
    public LocationException(String message) {
        super(message);
    }

    public LocationException(Exception e) {
        super(e);
    }
}
