package com.springproject.project1.customexception;

public class EmployeeNotFoundException extends Exception{
    public EmployeeNotFoundException(String msg){
        super(msg);
    }
}
