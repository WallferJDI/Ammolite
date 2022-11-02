package com.knits.ammolite.exceptions;

public class BuildingException extends AppException{

    public BuildingException(String message) {
        super(message);
    }

    public BuildingException(Exception e) {
        super(e);
    }
}
