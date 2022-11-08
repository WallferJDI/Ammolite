package com.knits.ammolite.exceptions;

public class EmployeeException extends AppException{

    public EmployeeException(String message){
        super(message);
    }

    public EmployeeException(Exception e){
        super(e);
    }
}
