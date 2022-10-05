package com.knits.ammolite.exceptions;

public class OrganizationException extends AppException{

    public OrganizationException(String message) {
        super(message);
    }

    public OrganizationException(Exception e) {
        super(e);
    }
}
