package com.knits.ammolite.exceptions;

public class SystemException extends AppException{

    public SystemException(String message){
        super(message);
    }

    public SystemException(Exception e){
        super(e);
    }
}
