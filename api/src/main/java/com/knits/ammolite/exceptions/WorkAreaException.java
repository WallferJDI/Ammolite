package com.knits.ammolite.exceptions;

public class WorkAreaException extends AppException{

    public WorkAreaException(String message) {
        super(message);
    }

    public WorkAreaException(Exception e) {
        super(e);
    }
}
