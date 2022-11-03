package com.knits.ammolite.exceptions;

public class FloorException extends AppException{

    public FloorException(String message) {
        super(message);
    }

    public FloorException(Exception e) {
        super(e);
    }
}
